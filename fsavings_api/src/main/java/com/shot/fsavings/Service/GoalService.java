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

    public JSONObject generateGoal(String id) {
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
                expectedSavings = (long)(expectedSavings / 10.0) + expectedSavings;
                expectedExpenses = totalExpectedIncome - expectedSavings;
                savingsPercentage = (long) (100.0*(expectedSavings / (expectedSavings + expectedExpenses)));
                expensesPercentage = 100 - savingsPercentage;
                wants = (long)(expensesPercentage * 5.0 / 14);
                needs = (long)(expensesPercentage * 9.0 / 14);
            } else {
                totalExpectedIncome = expectedSavings + expectedExpenses;
                expectedExpenses = (long)(expectedExpenses / 10.0) + expectedExpenses;
                expectedSavings = totalExpectedIncome - expectedExpenses;
                expensesPercentage = (long)(100.0*expectedExpenses / (expectedSavings + expectedExpenses));
                savingsPercentage = 100 - expensesPercentage;
                wants = (long)(expensesPercentage * 6.0 / 14);
                needs = (long)(expensesPercentage * 8.0 / 14);
            }

            percentageTotal = wants + needs + savingsPercentage;
            if(percentageTotal!=100)
                LOGGER.debug("GoalService: generateGoal -- Error" +
                        "\n Total Percentage for (needs, wants, savings) = " + percentageTotal);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("savings", savingsPercentage);
            jsonObject.put("wants", wants);
            jsonObject.put("needs", needs);
            return jsonObject;
        } catch (Exception e) {
            LOGGER.debug("GoalService: generateGoal -- Error" +
                    "\n Total Percentage for (needs, wants, savings) = " + percentageTotal);
            return null;
        }
    }

    public void saveGoal(GoalEntity goal) {
        goalDao.saveGoal(goal);
    }

    public GoalEntity getGoal(String userId) {
        return goalDao.getGoal(userId);
    }
}
