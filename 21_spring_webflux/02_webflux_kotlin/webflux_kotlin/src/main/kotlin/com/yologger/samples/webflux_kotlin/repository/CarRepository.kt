package com.yologger.samples.webflux_kotlin.repository

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CarRepository: CoroutineCrudRepository<CarEntity, Long>, CustomCarRepository {
}