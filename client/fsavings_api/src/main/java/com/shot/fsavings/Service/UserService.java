package com.shot.fsavings.Service;


import com.shot.fsavings.Dao.UserJpa;
import com.shot.fsavings.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserJpa repository;

    public String checkUserLogin(String email, String password) {
        return repository.findUser(email, password);
    }

    public String addUser(User user) {
        return repository.addUser(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
