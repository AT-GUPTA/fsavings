package com.shot.fsavings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    private Long id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String profession;
    private Long risk; //1-No, 2-Low, 3-Medium
    private Boolean isIncrease;
    private String subject; //savings, expenses, investment
    private Boolean investmentAdvice;
    private Long expectedEarnings;
    private Long expectedSavings;
    private Long expectedInvestment;
}
