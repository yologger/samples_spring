package com.yologger.samples.webflux_kotlin.repository

import com.yologger.samples.webflux_kotlin.service.MemberDTO
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("member")
data class MemberEntity (
    @Id var id: Long? = null,
    @Column var email: String,
    @Column var name: String,
    @Column val password: String
) {
    fun toDTO(): MemberDTO {
        return MemberDTO(id = id, email = email, name = name, password = password)
    }
}