package com.shot.fsavings.Controller;

import com.shot.fsavings.Common.URI;
import com.shot.fsavings.Entity.GoalEntity;
import com.shot.fsavings.Service.DashboardService;
import com.shot.fsavings.Service.GoalService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    private DashboardService dashboardService;
    @Autowired
    private GoalService goalService;

    //suggestions
    @CrossOrigin
    @RequestMapping(value = URI.SAVE_GOAL_INFO, method = RequestMethod.POST)
    ResponseEntity<?> saveGoal(@RequestBody GoalEntity goal) {
        try {
            goalService.saveGoal(goal);
            return ResponseEntity.ok(goal);
        } catch (Exception e) {
            LOGGER.debug("DashboardController: saveGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @CrossOrigin
    @RequestMapping(value = URI.UPDATE_GOAL_INFO, method = RequestMethod.POST)
    ResponseEntity<?> generateGoal(@PathVariable String userId) {
        try {
            goalService.generateGoal(userId);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            LOGGER.debug("DashboardController: updateGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    //cash flows
    @CrossOrigin
    @RequestMapping(value = URI.GET_GOAL, method = RequestMethod.GET)
    ResponseEntity<?> getGoals(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(goalService.getGoal(userId));
        } catch (Exception e) {
            LOGGER.debug("DashboardController: getGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @CrossOrigin
    @RequestMapping(value = URI.GET_DASH_CONTENT, method = RequestMethod.GET)
    ResponseEntity<?> getDashContent(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(dashboardService.getDashContent(userId));
        } catch (Exception e) {
            LOGGER.debug("DashboardController: getGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }
}
