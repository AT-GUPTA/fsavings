package com.shot.fsavings.Service;

import com.shot.fsavings.Dao.DashboardDao;
import com.shot.fsavings.Entity.UserEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private DashboardDao dashboardDao;
}
