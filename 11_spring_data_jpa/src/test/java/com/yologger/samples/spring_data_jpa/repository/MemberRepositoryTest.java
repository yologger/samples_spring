package com.yologger.samples.spring_data_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional
    public void test() {
        MemberEntity member = MemberEntity.builder()
                .email("james@gmail.com")
                .password("1234")
                .build();

        entityManager.persist(member);

        PostEntity post1 = PostEntity.builder()
                .writer(member)
                .content("content1")
                .build();

        entityManager.persist(post1);

        PostEntity post2 = PostEntity.builder()
                .writer(member)
                .content("content2")
                .build();

        entityManager.persist(post2);

        entityManager.flush();

        List<PostEntity> posts = entityManager.createQuery("SELECT p FROM PostEntity p JOIN FETCH p.writer w", PostEntity.class)
                .getResultList();
    }
}












