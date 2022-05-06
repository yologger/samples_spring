package com.yologger.project.repository.member;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yologger.project.repository.post.PostEntity;
import com.yologger.project.repository.post.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.yologger.project.repository.member.QMemberEntity.memberEntity;
import static com.yologger.project.repository.post.QPostEntity.postEntity;

@SpringBootTest
@DisplayName("test")
class MemberEntityTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @AfterEach
    public void tearDown() {
        memberRepository.deleteAll();
        postRepository.deleteAll();
    }

    @DisplayName("test")
    @Test
    public void test() {

//        MemberEntity dummyMember1 = MemberEntity.builder().email("paul@gmail.com").name("paul").age(34).nation("usa").gender("man").password("1234").build();
//        MemberEntity dummyMember2 = MemberEntity.builder().email("john@gmail.com").name("john").age(23).nation("usa").gender("man").password("1234").build();
//        MemberEntity dummyMember3 = MemberEntity.builder().email("smith@gmail.com").name("smith").age(60).nation("usa").gender("man").password("1234").build();
//        List<MemberEntity> dummyMembers = Arrays.asList(dummyMember1, dummyMember2, dummyMember3);
//        memberRepository.saveAll(dummyMembers);
//
//        List<PostEntity> dummyPosts = Arrays.asList(
//                PostEntity.builder().content("content1").writer(dummyMember1).build(),
//                PostEntity.builder().content("content2").writer(dummyMember1).build(),
//                PostEntity.builder().content("content3").writer(dummyMember2).build(),
//                PostEntity.builder().content("content4").writer(dummyMember2).build(),
//                PostEntity.builder().content("content5").writer(dummyMember2).build(),
//                PostEntity.builder().content("content6").build()
//        );
//        postRepository.saveAll(dummyPosts);
//
//        // postRepository.flush();
//
//        // List<PostEntity> posts = postRepository.findAll();
//
//        List<Tuple> tuples = jpaQueryFactory
//                .select(memberEntity.email, postEntity.content)
//                .from(memberEntity)
//                .join(postEntity)
//                .on(memberEntity.id.eq(postEntity.writer.id))
//                .fetch();

        List<MemberEntity> dummyMembers = Arrays.asList(
                MemberEntity.builder().email("paul@gmail.com").name("paul").age(34).nation("usa").gender("man").password("1234").build(),
                MemberEntity.builder().email("john@gmail.com").name("john").age(23).nation("usa").gender("man").password("1234").build(),
                MemberEntity.builder().email("smith@gmail.com").name("smith").age(60).nation("usa").gender("man").password("1234").build(),
                MemberEntity.builder().email("jane@gmail.com").name("jane").age(45).nation("usa").gender("woman").password("1234").build(),
                MemberEntity.builder().email("ross@gmail.com").name("ross").age(15).nation("korea").gender("man").password("1234").build(),
                MemberEntity.builder().email("kane@gmail.com").name("kane").age(51).nation("korea").gender("man").password("1234").build(),
                MemberEntity.builder().email("monica@gmail.com").name("monica").age(39).nation("korea").gender("woman").password("1234").build(),
                MemberEntity.builder().email("ramos@gmail.com").name("ramos").age(51).nation("korea").gender("man").password("1234").build(),
                MemberEntity.builder().email("chandler@gmail.com").name("chandler").age(60).nation("france").gender("man").password("1234").build(),
                MemberEntity.builder().email("rachel@gmail.com").name("rachel").age(72).nation("france").gender("woman").password("1234").build(),
                MemberEntity.builder().email("messi@gmail.com").name("messi").age(22).nation("france").gender("man").password("1234").build()
        );
        memberRepository.saveAll(dummyMembers);

        SubQueryExpression subquery1 = JPAExpressions
                .selectFrom(memberEntity)
                .where(memberEntity.nation.eq("korea"));

        SubQueryExpression subquery2 = JPAExpressions
                .selectFrom(memberEntity)
                .where(memberEntity.nation.eq("france"));

        List<MemberEntity> members = query()

        assertThat(0).isEqualTo(8);
    }
}