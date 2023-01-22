package com.shot.fsavings.Controller;

import com.shot.fsavings.Common.URI;
import com.shot.fsavings.Domain.Reports;
import com.shot.fsavings.Service.OnboardingService;
import com.shot.fsavings.Service.ReportsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);

    @Autowired
    private ReportsService reportsService;

    @CrossOrigin
    @RequestMapping(value = URI.REPORTS, method = RequestMethod.GET)
    ResponseEntity<?> getReports(@PathVariable String userId) {
        try {
            LOGGER.debug("ReportsControlled: getReports -- Begin");
            List<Reports> result = reportsService.getReports(Long.valueOf(userId));
            LOGGER.debug("ReportsControlled: getReports -- Begin");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            LOGGER.debug("OnboardingController: checkUser -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    //cash flow>month>totals>  >>comments<<

    //reports>months>
}
