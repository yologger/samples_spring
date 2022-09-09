package com.yologger.samples.webflux_kotlin.repository

import kotlinx.coroutines.flow.Flow

interface CustomCarRepository {
    fun findCarsByManufacturer(manufacturer: String): Flow<CarEntity>
}