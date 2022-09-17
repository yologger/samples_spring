package com.yologger.samples.webflux_kotlin.repository

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.r2dbc.core.DatabaseClient

@DataR2dbcTest
class CarRepositoryTest {

    @Autowired
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var databaseClient: DatabaseClient

    @Test
    @DisplayName("자동차 저장 테스트")
    fun save() {
        val dummyName = "Genesis"
        val dummyManufacturer = "Hyndai"
        val car = CarEntity(name = dummyName, manufacturer = dummyManufacturer)
        runBlocking {
            val saved = carRepository.save(car)
            assertThat(saved.manufacturer).isEqualTo(dummyManufacturer)
        }
    }
}