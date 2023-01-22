package com.shot.fsavings.Controller;

import com.shot.fsavings.Common.URI;
import com.shot.fsavings.Entity.UserEntity;
import com.shot.fsavings.Service.OnboardingService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OnboardingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    private OnboardingService onboardingService;

    @CrossOrigin
    @RequestMapping(value = URI.USER_CHECK, method = RequestMethod.POST)
    ResponseEntity<?> checkUser(@PathVariable String email) {
        try {
            LOGGER.debug("OnboardingController: checkUser -- Begin");
            Long result = onboardingService.checkUser(email);
            LOGGER.debug("OnboardingController: checkUser -- Begin");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            LOGGER.debug("OnboardingController: checkUser -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @CrossOrigin
    @RequestMapping(value = URI.SAVE_USER_INFO, method = RequestMethod.POST)
    ResponseEntity<?> saveUser(@RequestBody UserEntity user) {
        try {
            LOGGER.info("User: " + user);
            onboardingService.saveUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            LOGGER.debug("OnboardingController: saveUser -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @RequestMapping(value = URI.UPDATE_USER_INFO, method = RequestMethod.POST)
    ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody JSONObject userInfo) {
        try {
            onboardingService.updateUser(id, userInfo);
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }
}