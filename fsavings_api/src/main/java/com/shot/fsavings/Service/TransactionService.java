package com.shot.fsavings.Service;

import com.shot.fsavings.Common.LoggingInfo;
import com.shot.fsavings.Dao.TransactionsDao;
import com.shot.fsavings.Entity.TransactionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements LoggingInfo {

    @Autowired
    TransactionsDao transactionsDao;

    public void addTransaction(TransactionsEntity transaction) {
        transactionsDao.addTransaction(transaction);
    }

    public List<TransactionsEntity> getAllTransactions(Long id) {
        return transactionsDao.getAllTransactions(id);
    }

    public ResponseEntity<?> addAllTransactions(MultipartFile file) {
        String message = "";
        if (hasCSVFormat(file)) {
            try {
                List<TransactionsEntity> transactions = getTransactionList(file);
                transactionsDao.addAllTransactions(transactions);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    private List<TransactionsEntity> getTransactionList(MultipartFile file) {
        BufferedReader br;
        List<TransactionsEntity> result = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                result.add(new TransactionsEntity(arr[0], Long.parseLong(arr[1]), Long.parseLong(arr[2]),
                        new SimpleDateFormat("yyyy/MM/dd").parse(arr[3]), arr[4]));
            }
            return result;
        } catch (Exception e) {
            LOGGER.info("Error: " + e);
        }
        return null;
    }

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
}
