package com.shot.fsavings.Service;

import com.shot.fsavings.Common.LoggingInfo;
import com.shot.fsavings.Dao.OnboardingDao;
import com.shot.fsavings.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnboardingService implements LoggingInfo {

    @Autowired
    private OnboardingDao onboardingDao;

    public Long checkUser(String email) {
        return onboardingDao.checkUser(email);
    }

    @Transactional
    public void saveUser(UserEntity user) {
        onboardingDao.saveUser(user);
    }

    public UserEntity getUser(Long id) {
        return onboardingDao.getUser(id);
    }

    public void updateUser(String id, JSONObject userInfo) {
        onboardingDao.updateUser(id, userInfo);
    }
}
