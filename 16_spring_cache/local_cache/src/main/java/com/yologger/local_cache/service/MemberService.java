package com.yologger.local_cache.service;

import com.yologger.local_cache.repository.MemberEntity;
import com.yologger.local_cache.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long addMember(MemberDTO member){
        MemberEntity saved = memberRepository.save(member.toEntity());
        return saved.getId();
    }

    @Cacheable
    public List<MemberDTO> getAllUsers() {
        return memberRepository.findAll()
                .stream()
                .map((m) -> m.toDTO())
                .collect(Collectors.toList());
    }

    @Cacheable(value = "memberCache", key = "#id")
    public MemberDTO findMemberById(Long id) {
        return memberRepository.findMemberById(id).orElseThrow(() -> new NullPointerException("No member")).toDTO();
    }

    @CacheEvict(value = "memberCache", key = "#id")
    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    @CachePut(value = "memberCache", key = "#id")
    public MemberDTO updatePassword(Long id, String password) {
        MemberEntity member = memberRepository.findMemberById(id).orElseThrow(() -> new NullPointerException("No member"));
        member.setPassword(password);
        return member.toDTO();
    }
}
