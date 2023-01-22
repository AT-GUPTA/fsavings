package com.shot.fsavings.Service;

import com.shot.fsavings.Dao.UserLoginDao;
import com.shot.fsavings.Entity.UserLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;

    public String checkUserLogin(String email, String password) {
        return userLoginDao.findUser(email, password);
    }

    public String addUser(UserLoginEntity user) {
        return userLoginDao.addUser(user);
    }

    public List<UserLoginEntity> getAllUsers() {
        return userLoginDao.findAll();
    }
}
