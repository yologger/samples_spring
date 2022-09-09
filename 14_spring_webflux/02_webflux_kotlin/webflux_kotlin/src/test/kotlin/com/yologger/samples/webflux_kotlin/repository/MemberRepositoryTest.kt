package com.yologger.samples.webflux_kotlin.repository

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.r2dbc.core.DatabaseClient

@DataR2dbcTest
class MemberRepositoryTest {

    @Autowired lateinit var memberRepository: MemberRepository

    @Autowired lateinit var databaseClient: DatabaseClient

    @Test
    @DisplayName("데이터 저장 테스트")
    fun save() {
        val dummyEmail = "son@gmail.com"
        val dummyName = "son"
        val dummyPassword = "1234"
        val member = MemberEntity(email = dummyEmail, name = dummyName, password = dummyPassword)
        runBlocking {
            val saved = memberRepository.save(member)
            assertThat(saved.email).isEqualTo(dummyEmail)
        }
    }

    @Test
    @DisplayName("데이터 조회 테스트")
    fun findAll() {
        runBlocking {

            val dummyMembers = listOf(
                MemberEntity(email = "paul@gmail.com", name = "paul", password = "1234"),
                MemberEntity(email = "smith@gmail.com", name = "smith", password = "1234"),
                MemberEntity(email = "jane@gmail.com", name = "jane", password = "1234"),
            )
            dummyMembers.forEach { member ->
                memberRepository.save(member)
            }

            val members = memberRepository.findAll().toList()
            assertThat(members.size).isNotZero()
        }
    }

    @Test
    @DisplayName("이메일로 사용자 조회")
    fun findByEmail() {
        val dummyEmail = "son@gmail.com"
        val dummyName = "son"
        val dummyPassword = "1234"
        val member = MemberEntity(email = dummyEmail, name = dummyName, password = dummyPassword)
        runBlocking {
            memberRepository.save(member)
            val queried = memberRepository.findByEmail(dummyEmail)
            assertThat(queried.email).isEqualTo(dummyEmail)
        }
    }

    @Test
    @DisplayName("이름으로 사용자 조회")
    fun findByName() {
        runBlocking {
            val dummyMembers = listOf(
                MemberEntity(email = "paul1@gmail.com", name = "paul", password = "1234"),
                MemberEntity(email = "paul2@gmail.com", name = "paul", password = "1234"),
            )
            dummyMembers.forEach { member ->
                memberRepository.save(member)
            }

            val members = memberRepository.findByName("paul").toList()
            assertThat(members.size).isEqualTo(dummyMembers.size)
        }
    }
}