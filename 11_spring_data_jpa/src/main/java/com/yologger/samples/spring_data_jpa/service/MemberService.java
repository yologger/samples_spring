package com.yologger.samples.spring_data_jpa.service;

import com.yologger.samples.spring_data_jpa.controller.JoinRequest;
import com.yologger.samples.spring_data_jpa.repository.MemberEntity;
import com.yologger.samples.spring_data_jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public ResponseEntity<Long> join(JoinRequest request) {
        MemberEntity member = MemberEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        MemberEntity saved = memberRepository.save(member);

        return new ResponseEntity(saved.getId(), HttpStatus.CREATED);
    }
}
