package com.yologger.samples.webflux_kotlin.repository

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface MemberRepository : CoroutineCrudRepository<MemberEntity, Long> {
    suspend fun findByEmail(email: String): MemberEntity

    @Query("SELECT * FROM person WHERE name = :name")
    suspend fun findByName(name: String): Flow<MemberEntity>
}