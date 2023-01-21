package com.shot.fsavings.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FinancesEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private Integer month;
    private Long calculatedEarnings;
    private Long calculatedSavings;
    private Long calculatedInvestment;
}
