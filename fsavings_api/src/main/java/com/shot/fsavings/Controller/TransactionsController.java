package com.shot.fsavings.Controller;

import com.shot.fsavings.Common.URI;
import com.shot.fsavings.Entity.TransactionsEntity;
import com.shot.fsavings.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = URI.ADD_TRANSACTION)
    ResponseEntity<?> addTransaction(@RequestBody TransactionsEntity transaction) {
        try {
            transactionService.addTransaction(transaction);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = URI.ADD_ALL_TRANSACTION)
    ResponseEntity<?> addAllTransactions(@RequestBody MultipartFile file) {
        try {
            return transactionService.addAllTransactions(file);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = URI.USER_TRANSACTION)
    ResponseEntity<?> getAllTransactions(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(transactionService.getAllTransactions(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }
}