package com.yologger.samples.webflux_kotlin.repository

import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.flow
import org.springframework.stereotype.Repository

@Repository
class CustomCarRepositoryImpl(
    @Autowired val client: DatabaseClient
): CustomCarRepository{

    override fun findCarsByManufacturer(manufacturer: String): Flow<CarEntity> {
        val query = "SELECT * FROM car WHERE manufacturer = :manufacturer"
        return client.sql(query)
            .bind("manufacturer", manufacturer)
            .map { row, _ ->
                val id: Long? = row.get("id", Long::class.java)
                val name = row.get("name", String::class.java) ?: throw NullPointerException("name field empty.")
                val manufacturer = row.get("manufacturer", String::class.java) ?: throw NullPointerException("manufacturer field empty.")
                CarEntity(id = id, name = name, manufacturer = manufacturer)
            }
            .flow()
    }
}