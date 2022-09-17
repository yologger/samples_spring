package com.yologger.samples.webflux_kotlin.service

import com.yologger.samples.webflux_kotlin.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService constructor(
    @Autowired val memberRepository: MemberRepository
){
    suspend fun addMember(member: MemberDTO): MemberDTO = memberRepository.save(member.toEntity()).toDTO()

    suspend fun findMemberById(id: Long): MemberDTO {
        return memberRepository.findById(id)?.toDTO()
            ?: throw NullPointerException("No member")
    }

    suspend fun findAllMember(): Flow<MemberDTO> {
        return memberRepository.findAll().map { it.toDTO() }
    }
}