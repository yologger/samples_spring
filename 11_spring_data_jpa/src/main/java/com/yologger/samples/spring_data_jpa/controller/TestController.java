package com.yologger.samples.spring_data_jpa.controller;

import com.yologger.samples.spring_data_jpa.repository.MemberEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/test")
public class TestController {
    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/test")
    @Transactional
    public String test() {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            MemberEntity member = MemberEntity.builder().email("smith@gmail.com").password("1234").build();
            entityManager.persist(member);

            transaction.commit();

            return "test";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "error";
        } finally {
            entityManager.close();
        }
    }
}
