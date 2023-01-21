package com.shot.fsavings.Entity;

import jakarta.persistence.*;
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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date dateOfBirth;

    @Column
    private String profession;

    @Column
    private Long risk; //1-No, 2-Low, 3-Medium

    @Column
    private Boolean isIncrease;

    @Column
    private String subject; //savings, expenses, investment

    @Column
    private Boolean investmentAdvice;

    @Column
    private Long expectedEarnings;

    @Column
    private Long expectedSavings;

    @Column
    private Long expectedInvestment;
}
