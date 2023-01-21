package com.shot.fsavings.Controller;
import com.shot.fsavings.Entity.User;
import com.shot.fsavings.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Login user by id
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public String getUser(@RequestBody Map<String, String> json) {
        return userService.checkUserLogin(json.get("email"), json.get("password"));
    }

    //Add a new user
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //Get all the users
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

