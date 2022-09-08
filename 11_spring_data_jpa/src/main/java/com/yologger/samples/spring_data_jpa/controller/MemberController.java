package com.yologger.samples.spring_data_jpa.controller;

import com.yologger.samples.spring_data_jpa.repository.MemberEntity;
import com.yologger.samples.spring_data_jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @PersistenceContext
    private final EntityManager entityManager;

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Long> join(@RequestBody JoinRequest request) {
        return memberService.join(request);
    }

    @GetMapping("/test")
    @Transactional
    public String test() {
        MemberEntity member = MemberEntity.builder()
                .email("tester@gmail.com")
                .password("1234")
                .build();
        entityManager.persist(member);
        return "saved";
    }
}
