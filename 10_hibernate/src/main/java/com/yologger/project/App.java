package com.yologger.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("test_persistence");
        EntityManager entityManager = entityManagerfactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            MemberEntity member = entityManager.find(MemberEntity.class, 1L);
            Map<String, PostEntity> posts = member.getPosts();
            PostEntity post = posts.get(1L);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerfactory.close();
    }
}