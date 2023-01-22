package com.shot.fsavings.Dao;

import com.shot.fsavings.Entity.GoalEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoalDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public boolean generateGoal(String id) {
        try {
            Long goalId = Long.parseLong(id);
            Long needs;
            Long wants;

            return true;
        } catch (Exception e) {
            LOGGER.info("GoalDao: generateGoal -- Error");
            return false;
        }
    }

    public void saveGoal(GoalEntity goal) {
        try {
            List<Long> idList = entityManager.createQuery("SELECT goal FROM GoalEntity goal", GoalEntity.class)
                    .getResultList().stream().map(GoalEntity::getId).toList();
            if (idList.contains(goal.getId())) {
                entityManager.merge(goal);
            } else {
                entityManager.persist(goal);
            }
        } catch (Exception e) {
            LOGGER.info("GoalDao: saveGoal -- Error");
        }
    }
}
