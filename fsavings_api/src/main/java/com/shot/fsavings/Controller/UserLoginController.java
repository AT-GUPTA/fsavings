package com.shot.fsavings.Controller;

import com.shot.fsavings.Entity.UserLoginEntity;
import com.shot.fsavings.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    //Login user by id
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public String getUser(@RequestBody Map<String, String> json) {
        return userLoginService.checkUserLogin(json.get("email"), json.get("password"));
    }

    //Add a new user
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(@RequestBody UserLoginEntity user) {
        return userLoginService.addUser(user);
    }

    //Get all the users
    @RequestMapping("/users")
    public List<UserLoginEntity> getAllUsers() {
        return userLoginService.getAllUsers();
    }
}
