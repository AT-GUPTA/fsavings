package com.shot.fsavings.Service;

import com.shot.fsavings.Controller.ReportsController;
import com.shot.fsavings.Dao.OnboardingDao;
import com.shot.fsavings.Dao.ReportsDao;
import com.shot.fsavings.Dao.TransactionsDao;
import com.shot.fsavings.Domain.CashFlow;
import com.shot.fsavings.Domain.Reports;
import com.shot.fsavings.Entity.TransactionsEntity;
import com.shot.fsavings.Entity.UserEntity;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);

    @Autowired
    private OnboardingDao onboardingDao;
    @Autowired
    private TransactionsDao transactionDao;

    @Autowired
    private ReportsDao reportsDao;
    public List<Reports> getReports(Long userId) {

        List<TransactionsEntity> transactions = transactionDao.getAllTransactions(userId);
        if(transactions.isEmpty())
            return null;

        HashMap<String,Reports> allReports=new HashMap<>();

        for(TransactionsEntity transaction:transactions) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(transaction.getDateOfTransaction());
            String reportName=cal.get(Calendar.MONTH)+"-"+ cal.get(Calendar.YEAR);
            Reports curReport;
            if(!allReports.containsKey(reportName))
            {
                curReport=new Reports();
                curReport.setDate(transaction.getDateOfTransaction());
                curReport.setCreditTransactions(new ArrayList<>());
                curReport.setDebitTransactions(new ArrayList<>());
            }
            else {
                curReport=allReports.get(reportName);
            }
            if(transaction.getCredit()!=null && transaction.getDebit()==null)
            {
                curReport.getCreditTransactions().add(transaction);
            } else if (transaction.getDebit()!=null && transaction.getCredit()==null) {
                curReport.getDebitTransactions().add(transaction);
            }
            curReport.getCreditTransactions().sort(Comparator.comparing(TransactionsEntity::getDateOfTransaction));
            Collections.reverse(curReport.getCreditTransactions());

            curReport.getDebitTransactions().sort(Comparator.comparing(TransactionsEntity::getDateOfTransaction));
            Collections.reverse(curReport.getDebitTransactions());

            allReports.put(reportName,curReport);
        }
        for(Reports rep:allReports.values())
        {
            rep.setCashFlow(generateCashFlow(rep,userId));
        }

        return new ArrayList<>(allReports.values());
    }

    private CashFlow generateCashFlow(Reports report,Long userId){

            Long expenses=0L;
            Long earnings=0L;
            CashFlow cashFlow = new CashFlow();
            for(TransactionsEntity trans:report.getDebitTransactions())
            {
                expenses=expenses+trans.getDebit();
            }
            for(TransactionsEntity trans:report.getCreditTransactions())
            {
                earnings=earnings+trans.getCredit();
            }
            Long savings=earnings-expenses;
            UserEntity user = onboardingDao.getUser(userId);
            cashFlow.setEarnings(earnings);
            cashFlow.setExpenses(expenses);
            cashFlow.setSavings(savings);
            cashFlow.setGoalExpenses(user.getExpectedEarnings()-user.getExpectedSavings());
            cashFlow.setGoalSavings(user.getExpectedSavings());
            cashFlow.setNetAmount(earnings-expenses);

            return cashFlow;
    }

    public Double getExpenseOpt() {
        //to pull changes from remote/ad-9kwerkpo0/ydteXZmmZp%
        return (10.0/14);
    }
}
