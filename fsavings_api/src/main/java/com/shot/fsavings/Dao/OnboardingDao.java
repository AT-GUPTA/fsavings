package com.shot.fsavings.Dao;

import com.shot.fsavings.Entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OnboardingDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long checkUser(String email) {
        try{
            Long userid=entityManager.createQuery("select user from UserEntity user where user.email=:email", UserEntity.class)
                    .setParameter("email",email)
                    .getSingleResult().getId();
        }
        catch (Exception e){
            return 0L;
        }
    }
}
