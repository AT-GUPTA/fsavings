package com.shot.fsavings.Dao;

import com.shot.fsavings.Entity.TransactionsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionsDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<TransactionsEntity> getAllTransactions(long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionsEntity> criteriaQuery = criteriaBuilder.createQuery(TransactionsEntity.class);
        Root<TransactionsEntity> root = criteriaQuery.from(TransactionsEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("dateOfTransaction")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public void addTransaction(TransactionsEntity transaction) {
        entityManager.persist(transaction);
    }

    @Transactional
    public void addAllTransactions(List<TransactionsEntity> transactions) {
        transactions.forEach(transaction -> {
            entityManager.persist(transaction);
        });
    }
}

