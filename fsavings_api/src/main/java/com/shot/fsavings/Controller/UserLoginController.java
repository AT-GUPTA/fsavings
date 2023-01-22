package com.shot.fsavings.Controller;

import com.shot.fsavings.Entity.UserLoginEntity;
import com.shot.fsavings.Service.OnboardingService;
import com.shot.fsavings.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private OnboardingService onboardingService;

    //Login user by id
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public ResponseEntity<?> getUser(@RequestBody Map<String, String> json) {
        try {
            String s = userLoginService.checkUserLogin(json.get("email"), json.get("password"));
            if (s.isEmpty())
                return ResponseEntity.ok(getMessage("message","FAILURE"));
            return ResponseEntity.ok(getMessage("message","" + onboardingService.checkUser(s)));
        } catch (Exception e) {
            return ResponseEntity.ok(getMessage("message","FAILURE"));
        }
    }

    //Add a new user
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<?> addUser(@RequestBody UserLoginEntity user) {
        try {
            return ResponseEntity.ok(userLoginService.addUser(user));
        } catch (Exception e) {
            return ResponseEntity.ok(getMessage("message","FAILURE"));
        }
    }

    private static String getMessage(String key, String message) {
        return String.format("{\"%s\":\"%s\"}", key, message);
    }

    //Get all the users
    @CrossOrigin
    @RequestMapping("/users")
    public List<UserLoginEntity> getAllUsers() {
        return userLoginService.getAllUsers();
    }
}
