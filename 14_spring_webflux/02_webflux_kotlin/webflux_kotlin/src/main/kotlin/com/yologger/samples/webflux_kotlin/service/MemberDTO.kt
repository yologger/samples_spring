package com.yologger.samples.webflux_kotlin.service

import com.yologger.samples.webflux_kotlin.repository.MemberEntity

data class MemberDTO(
    val id: Long? = null,
    val email: String,
    val name: String,
    val password: String
) {
    fun toEntity(): MemberEntity {
        return MemberEntity(id = id, email = email, name = name, password = password)
    }
}