package com.shot.fsavings.Service;

import com.shot.fsavings.Dao.DashboardDao;
import com.shot.fsavings.Dao.GoalDao;
import com.shot.fsavings.Domain.CashFlow;
import com.shot.fsavings.Domain.Reports;
import com.shot.fsavings.Entity.GoalEntity;
import com.shot.fsavings.Entity.UserEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private GoalDao goalDao;
    @Autowired
    private ReportsService reportsService;

    public JSONObject getDashContent(String userId) {
        try{
            Reports reports= reportsService.getReports(Long.valueOf(userId)).get(0);
            JSONObject json=new JSONObject();
            CashFlow cf=reports.getCashFlow();
            json.put("earnings",cf.getEarnings());
            json.put("savings",cf.getSavings());
            json.put("date",reports.getDate());
            GoalEntity goal = goalDao.getGoal(userId);

            json.put("percentSavings",goal.getSavings());
            Long actualSavings=cf.getSavings()/(cf.getEarnings()+cf.getSavings())*100;

            json.put("actualSavings",actualSavings);
            json.put("percentWants",goal.getWants());
            json.put("percentNeeds",goal.getNeeds());

            Long needs=(long)((100.0-(actualSavings))*reportsService.getExpenseOpt());
            Long wants=100-actualSavings-needs;
            json.put("actualNeeds",needs);
            json.put("actualWants",wants);

            return json;

        } catch (Exception e){
            return new JSONObject().put("message", "FAILURE");
        }

    }
}
