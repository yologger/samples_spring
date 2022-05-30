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

            MemberEntity member = new MemberEntity("Paul", "1234");

            PostEntity post = new PostEntity("content1");
            post.setWriter(member);

            // 부모 엔티티만 영속화
            entityManager.persist(member);

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