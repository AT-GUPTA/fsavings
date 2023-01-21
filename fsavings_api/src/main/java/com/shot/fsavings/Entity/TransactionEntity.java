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
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column
    private String transactionDescription;
    @Column
    private Double credit;
    @Column
    private Double debit;
    @Column
    private Date dateOfTransaction;
    @Column
    private String category;
}
