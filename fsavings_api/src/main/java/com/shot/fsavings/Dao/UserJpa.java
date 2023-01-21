package com.shot.fsavings.Dao;

import com.shot.fsavings.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserJpa {
    @PersistenceContext
    EntityManager entityManager;

    public String findUser(String email, String password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.and(builder.equal(root.get("email"),
                        email),
                builder.equal(root.get("password"), password)));
        List<User> user = entityManager.createQuery(query).getResultList();
        String username = user.isEmpty() ? "" : user.get(0).getUsername();
        return getMessage(username);
    }

    public String addUser(User user) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> emailList = entityManager.createQuery(query).getResultList();
        boolean emailInList =
                emailList.stream().anyMatch(user1 -> user.getEmail()
                        .equals(user1.getEmail()));
        boolean usernameInList =
                emailList.stream().anyMatch(user1 -> user.getUsername()
                        .equals(user1.getUsername()));

        if (emailInList && usernameInList)
            return getMessage("Username and Email Id already exists");
        else if (usernameInList)
            return getMessage("Username already exists");
        else if (emailInList)
            return getMessage("Email already exists");
        else
            entityManager.merge(user);

        return getMessage("Account created!");
    }

    private static String getMessage(String message) {
        return String.format("{\"message\":\"%s\"}", message);
    }

    public List<User> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        query.from(User.class);
        return entityManager.createQuery(query).getResultList();
    }
}
