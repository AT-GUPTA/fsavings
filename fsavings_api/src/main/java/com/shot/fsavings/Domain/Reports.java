package com.shot.fsavings.Domain;

import com.shot.fsavings.Entity.TransactionsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reports {
    private Date date;
    private CashFlow cashFlow;
    private List<TransactionsEntity> creditTransactions;
    private List<TransactionsEntity> debitTransactions;
}
