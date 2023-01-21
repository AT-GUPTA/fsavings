package com.shot.fsavings.Service;

import com.shot.fsavings.Dao.OnboardingDao;
import com.shot.fsavings.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnboardingService {

    @Autowired
    private OnboardingDao onboardingDao;
    public Boolean checkUser(String email) {
        return onboardingDao.checkUser(email);
    }

    public void saveUser(UserEntity user) {
    }
}
