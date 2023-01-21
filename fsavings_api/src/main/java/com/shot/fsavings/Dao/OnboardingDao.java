package com.shot.fsavings.Dao;

import com.shot.fsavings.Controller.OnboardingController;
import com.shot.fsavings.Entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OnboardingDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Long checkUser(String email) {
        try{
            Long userid=entityManager.createQuery("select user from UserEntity user where user.email=:email", UserEntity.class)
                    .setParameter("email",email)
                    .getSingleResult().getId();
            return userid;
        }
        catch (Exception e){
            return 0L;
        }
    }

    public void saveUser(UserEntity user) {
        try{
            entityManager.persist(user);
        }
        catch (Exception e){
            LOGGER.info("Save User Error!");
        }

    }
}
