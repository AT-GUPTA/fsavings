package com.shot.fsavings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String email;
    private String password;
    private Date birthDate;

    public User(String username, String email, String password, Date birthDate) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }
}
