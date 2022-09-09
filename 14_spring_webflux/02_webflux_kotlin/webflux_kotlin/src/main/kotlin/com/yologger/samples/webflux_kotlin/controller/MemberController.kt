package com.yologger.samples.webflux_kotlin.controller

import com.yologger.samples.webflux_kotlin.service.MemberDTO
import com.yologger.samples.webflux_kotlin.service.MemberService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController constructor(
    @Autowired val memberService: MemberService
){
    @PostMapping
    suspend fun addMember(@RequestBody request: AddMemberRequest): ResponseEntity<Long> {
        return ResponseEntity(memberService.addMember(MemberDTO(email = request.email, name = request.name, password = request.password)).id!!, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    suspend fun findMemberById(@PathVariable("id") id: Long): ResponseEntity<MemberDTO> {
        return ResponseEntity(memberService.findMemberById(id), HttpStatus.OK)
    }

    @GetMapping("")
    suspend fun findAllMembers(): ResponseEntity<Flow<MemberDTO>> {
        return ResponseEntity(memberService.findAllMember(), HttpStatus.OK)
    }
}