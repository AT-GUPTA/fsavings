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
public class OnboardingDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Long checkUser(String email) {
        try{
            return entityManager.createQuery("select user from UserEntity user where user.email=:email", UserEntity.class)
                    .setParameter("email",email)
                    .getSingleResult().getId();
        }
        catch (Exception e){
            return 0L;
        }
    }

    public void saveUser(UserEntity user) {
        try {
            Long userId = checkUser(user.getEmail());
            if (userId.equals(0L)) {
                entityManager.persist(user);

            } else {
                entityManager.merge(user);
            }
        } catch (Exception e) {
            LOGGER.info("OnboardingDao: saveUser -- Error");
        }

    }

    public UserEntity getUser(Long id) {
        try {
            return entityManager.createQuery("select user from UserEntity user where user.id=:id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.debug("OnboardingDao: getUser -- Error");
            return null;
        }
    }

    // Unused
    public void updateUser(String id, JSONObject userInfo) {
        try {
            Long userId = Long.parseLong(id);
            UserEntity user = getUser(userId);
            if (user == null) {
                String userName = (String) userInfo.get("userName");
                String email = (String) userInfo.get("email");
                String firstName = (String) userInfo.get("firstName");
                String lastName = (String) userInfo.get("lastName");
                Date dateOfBirth = (Date) userInfo.get("dateOfBirth");
                String profession = (String) userInfo.get("profession");
                Long risk = (Long) userInfo.get("risk");
                Boolean isIncrease = (Boolean) userInfo.get("isIncrease");
                String subject = (String) userInfo.get("subject");
                Boolean investmentAdvice = (Boolean) userInfo.get("investmentAdvice");
                Long expectedEarnings = (Long) userInfo.get("expectedEarnings");
                Long expectedSavings = (Long) userInfo.get("expectedSavings");
                Long expectedInvestment = (Long) userInfo.get("expectedInvestment");
            } else {
                String[] arr = {"userName, email, firstName, lastName, dateOfBirth, profession, risk, isIncrease, subject," +
                        " investmentAdvice, expectedEarnings, expectedSavings, expectedInvestment"};

                String SqlQuery = "UPDATE TABLE UserEntity SET ";
                for (int i = 0; i < arr.length; i++) {
                    if (userInfo.get(arr[i]) != null) {
                        SqlQuery += arr[i] + "=" + userInfo.get(arr[i]) + " ";
                    }
                }
                SqlQuery.trim();
                entityManager.createQuery(SqlQuery);
                entityManager.merge(user);


//            if (userInfo.has("userName")) {
//                user.setUserName((String) userInfo.get("userName"));
//            }
//            if (userInfo.has("email")) {
//                user.setEmail((String) userInfo.get("email"));
//            }
//            if (userInfo.has("firstName")) {
//                user.setFirstName((String) userInfo.get("firstName"));
//            }
//            if (userInfo.has("lastName")) {
//                user.setLastName((String) userInfo.get("lastName"));
//            }
//            if (userInfo.has("dateOfBirth")) {
//                user.setDateOfBirth((Date) userInfo.get("dateOfBirth"));
//            }
//            if (userInfo.has("profession")) {
//                user.setProfession((String) userInfo.get("profession"));
//            }
//            if (userInfo.has("risk")) {
//                user.setRisk((Long) userInfo.get("risk"));
//            }
//            if (userInfo.has("isIncrease")) {
//                user.setIsIncrease((Boolean) userInfo.get("isIncrease"));
//            }
//            if (userInfo.has("subject")) {
//                user.setSubject((String) userInfo.get("subject"));
//            }
//            if (userInfo.has("investmentAdvice")) {
//                user.setInvestmentAdvice((Boolean) userInfo.get("investmentAdvice"));
//            }
//            if (userInfo.has("expectedEarnings")) {
//                user.setExpectedEarnings((Long) userInfo.get("expectedEarnings"));
//            }
//            if (userInfo.has("expectedSavings")) {
//                user.setExpectedSavings((Long) userInfo.get("expectedSavings"));
//            }
//            if (userInfo.has("expectedInvestment")) {
//                user.setExpectedInvestment((Long) userInfo.get("expectedInvestment"));
//            }
            }
        } catch (Exception e) {
            LOGGER.debug("OnboardingDao: getUser -- Error");
        }
    }
}
