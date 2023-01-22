from flask import Flask

app = Flask(__name__)

@app.route('/', methods=['GET'])
def welcome():
    return "Hello World!"

################################################################################
# Only execute the code if the script is ran and not if it is imported         #
################################################################################
#if __name__ == "__main__":
import numpy as np                        # Numerical Python package
import tabula                             # PDF table extra package
import numpy as np
import pandas as pd
import csv
import os
import re,string
import sys
from tabula.io import read_pdf
from dateutil.parser import parse # Fixing the dates

if not sys.warnoptions:
    import warnings
    warnings.simplefilter("ignore")

# The path to the PDF bank statement
filepath = './BankStatement.pdf'


def clean_trns_desc(text):
    text = text.lower()
    # removing anything within square brackets
    text = re.sub('\[.*?\]', '', text) #TODO: Ensure this is not excluding stuff
    # if any of these punctuation marks in (string.punctuation) get rid of it
    text = re.sub('[%s]' % re.escape(string.punctuation), '', text)
    # Getting rid of all numbers
    text = re.sub('\d+', '', text)
    # get rid of the word purch
    text = re.sub('purch', '', text)
    # Get rid of the word annkp
    text = re.sub('aankp', '', text)
    text = re.sub('puchc', '', text)
    text = re.sub('aankg', '', text)
    return text

round1 = lambda x: clean_trns_desc(x)

try:
     df_list = tabula.read_pdf(filepath,stream=True,guess=True,pages='all',
                         multiple_tables=True,
                         pandas_options={
                              'header':None}
                         )
except Exception as e:
     print('The Error is',e)


### Clean up each page before joining them together
df = []
for dfs in df_list:
     dfs = dfs[dfs.columns[dfs.isnull().mean() < 0.8]]
     # Drop rows with any empty cells
     # dfs.dropna(axis=0,how='any',thresh=2,subset=None,inplace=True)
     dfs.dropna(axis=0,thresh=2,subset=None,inplace=True)
     # dfs['Description'] = dfs.iloc[:,1].str.cat(dfs.iloc[:,2],sep=" ")
     if dfs.shape[1] > 5:
          dfs.drop(dfs.columns[-1],axis=1,inplace=True)
          df.append(dfs)
     else:
          df.append(dfs)

# Join individual dataframes into one

# df_fin = pd.concat([df[1],df[2],df[3],df[4]], axis=0, sort=False) #FIX: make this part dynamic!
df = str(df[0])
stringList = df.split('\n')
# new_df  = pd.DataFrame([x.split('\t') for x in stringList], columns=list('ABC'))
# new_df = stringList[1].split("        ")
# new_df = stringList[2].split(" ")
# print(new_df)
# new_df  = re.split(r'\s{2,}', stringList[1])
# print(new_df)
# df_fin = df_fin[~df_fin.iloc[:,0].str.contains("Date")]
# df_fin.columns = ['date',"trns_desc_1",'trns_desc_2','trns_desc_3','amount','balance']
# print(df_fin)
# print(df_fin.sample(4))

def stringOptimization(allstring):
     stringList = ""
     export_csv = ""
     for stri in allstring:
          stri = stri.split()
          serial=stri[0]
          date = stri[1]+' '+ stri[2]
          length=len(stri)
          withdrawal = stri[length-3]
          credit = stri[length-2]
          balance = stri[length-1]
          desc=""
          for x in range(length):
               if x >=3 and x<length-3:
                    desc=desc+' '+stri[x]
          stringList = stringList+ serial + ';'+ date +';'+ desc+';' + withdrawal +';' +credit + ';'+balance + "\n"
          export_csv = export_csv + desc +","+ credit.replace(",","")+","+ withdrawal.replace(",","")+","+date+","+'xyz'+"$"
          print(export_csv)
     return export_csv
data  = stringOptimization(stringList)
print(data)

# df = pd.DataFrame([data.split(';') for data in new_list.split('\n')])
# df  = df.drop(labels=[0,1], axis=0)
# df = df.reset_index()
# df2 = df.iloc[:-1 , :]
# df2 = df2.drop(['index'], axis=1)
# df2 = df2.drop([0], axis=1)
# df = df2
# df.columns = ['date',"trns_desc",'withdrawal','deposits','balance']
# print(df)


# file = open('data.csv', 'a')
# for line in data:
#      print(line)
#      file.write(line)
# file.close()





@app.route('/data', methods=['POST'])
def sendcsv():
     return data


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=105)