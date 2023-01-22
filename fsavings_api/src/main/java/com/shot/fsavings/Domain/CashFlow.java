package com.shot.fsavings.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashFlow {

    private Long earnings;
    private Long savings;
    private Long expenses;
    private Long goalSavings;
    private Long goalExpenses;
    private Long netAmount;
}
