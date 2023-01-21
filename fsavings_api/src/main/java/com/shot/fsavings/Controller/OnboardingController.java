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

import java.text.SimpleDateFormat;

@RestController
public class OnboardingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    private OnboardingService onboardingService;


    @RequestMapping(value=URI.USER_CHECK, method=RequestMethod.POST)
    ResponseEntity<?> checkUser(@PathVariable String email){
        try{
            LOGGER.debug("OnboardingController: checkUser -- Begin");
            Long result = onboardingService.checkUser(email);
            LOGGER.debug("OnboardingController: checkUser -- Begin");
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            LOGGER.debug("OnboardingController: checkUser -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }
    @RequestMapping(value= URI.SAVE_USER_INFO,method= RequestMethod.POST)
    ResponseEntity<?> saveUser(@PathVariable String email, @RequestBody String jsonDetails){

        try {
            JSONObject userInfo = new JSONObject(jsonDetails);

            UserEntity user = new UserEntity(
                    userInfo.getLong("id"),
                    userInfo.getString("userName"),
                    userInfo.getString("email"),
                    userInfo.getString("firstName"),
                    userInfo.getString("lastName"),
                    new SimpleDateFormat("yyyy-MM-dd").parse(userInfo.getString("dateOfBirth")),
                    userInfo.getString("profession"),
                    userInfo.getLong("risk"),
                    userInfo.getBoolean("isIncrease"),
                    userInfo.getString("subject"),
                    userInfo.getBoolean("isInvestmentAdvice"),
                    );
            onboardingService.saveUser(user);
            return null;
        }catch(Exception e){
            return null;
        }
    }

}
