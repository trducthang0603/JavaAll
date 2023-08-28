package com.example.RestAPI.restfulapi;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.RestAPI.restfulapi.UserName;
@Repository
public class CustomUserRepository {

    @PersistenceContext
    private EntityManager em;

    public UserName getUserById(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserName> query = builder.createQuery(UserName.class);
        Root<UserName> root = query.from(UserName.class);

        Predicate condition = builder.equal(root.get("id"), id);


        query.select(root).where(condition);
        return em.createQuery(query).getSingleResult();
    }

    public Collection<UserName> getUserByComplexConditions(String name, UserName.UserType type) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserName> query = builder.createQuery(UserName.class);
        Root<UserName> root = query.from(UserName.class);

        Predicate hasNameLike = builder.like(root.get("name"), name);
        Predicate hasType = builder.equal(root.get("type"), type);

        Predicate condition = builder.and(hasNameLike, hasType);

        query.select(root).where(condition);
        return em.createQuery(query).getResultList();
    }
}