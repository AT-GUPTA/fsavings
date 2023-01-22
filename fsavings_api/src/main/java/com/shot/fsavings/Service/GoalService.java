package com.shot.fsavings.Service;

import com.shot.fsavings.Controller.OnboardingController;
import com.shot.fsavings.Dao.GoalDao;
import com.shot.fsavings.Entity.GoalEntity;
import com.shot.fsavings.Entity.UserEntity;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    private GoalDao goalDao;
    @Autowired
    private OnboardingService onboardingService;

    public void generateGoal(String id) {
        Long percentageTotal = 0L;
        try {
            LOGGER.debug("GoalService: generateGoal -- Begin");

            Long userId = Long.parseLong(id);
            UserEntity user = onboardingService.getUser(userId);
            Long expectedEarnings = user.getExpectedEarnings();
            Long expectedSavings = user.getExpectedSavings();
            Boolean isIncrease = user.getIsIncrease();
            String subject = user.getSubject();

            Long expectedExpenses = expectedEarnings - expectedSavings;

            Long totalExpectedIncome;
            Long savingsPercentage;
            Long expensesPercentage;
            Long wants;
            Long needs;

            if ((isIncrease && subject.equalsIgnoreCase("saving")) ||
                    (!isIncrease && subject.equalsIgnoreCase("expense"))) {
                totalExpectedIncome = expectedSavings + expectedExpenses;
                expectedSavings = (expectedSavings / 10) + expectedSavings;
                expectedExpenses = totalExpectedIncome - expectedSavings;
                savingsPercentage = (expectedSavings / (expectedSavings + expectedExpenses)) * 100;
                expensesPercentage = 100 - savingsPercentage;
                wants = expensesPercentage * 5 / 14;
                needs = expensesPercentage * 9 / 14;
            } else {
                totalExpectedIncome = expectedSavings + expectedExpenses;
                expectedExpenses = (expectedExpenses / 10) + expectedExpenses;
                expectedSavings = totalExpectedIncome - expectedExpenses;
                expensesPercentage = (expectedExpenses / (expectedSavings + expectedExpenses)) * 100;
                savingsPercentage = 100 - expensesPercentage;
                wants = expensesPercentage * 6 / 14;
                needs = expensesPercentage * 8 / 14;
            }

            percentageTotal = wants + needs + savingsPercentage;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("savings", savingsPercentage);
            jsonObject.put("wants", wants);
            jsonObject.put("needs", needs);
        } catch (Exception e) {
            LOGGER.debug("GoalService: generateGoal -- Error" +
                    "\n Total Percentage for (needs, wants, savings) = " + percentageTotal);
        }
    }

    public void saveGoal(GoalEntity goal) {
        goalDao.saveGoal(goal);
    }
}
