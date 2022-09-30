package com.yologger.samples.spring_data_jpa.service;

import com.yologger.samples.spring_data_jpa.model.JoinRequest;
import com.yologger.samples.spring_data_jpa.repository.MemberEntity;
import com.yologger.samples.spring_data_jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public Long join(JoinRequest request) {
        MemberEntity member = MemberEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        MemberEntity saved = memberRepository.save(member);

        return saved.getId();
    }
}
