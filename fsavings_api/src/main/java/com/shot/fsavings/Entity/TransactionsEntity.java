package com.shot.fsavings.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column
    private String transactionDescription;
    @Column
    private Long credit;
    @Column
    private Long debit;
    @Column
    private Date dateOfTransaction;
    @Column
    private String category;

    public TransactionsEntity(String transactionDescription, Long credit, Long debit,
                       Date dateOfTransaction, String category) {
        this.transactionDescription = transactionDescription;
        this.credit = credit;
        this.debit = debit;
        this.dateOfTransaction = dateOfTransaction;
        this.category = category;
    }
}
