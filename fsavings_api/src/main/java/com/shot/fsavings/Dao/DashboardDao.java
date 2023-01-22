package com.shot.fsavings.Dao;

import com.shot.fsavings.Entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DashboardDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingDao.class);

    @PersistenceContext
    private EntityManager entityManager;
}
