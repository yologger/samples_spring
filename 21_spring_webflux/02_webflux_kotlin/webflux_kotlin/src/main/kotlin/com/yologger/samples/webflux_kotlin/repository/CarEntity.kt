package com.yologger.samples.webflux_kotlin.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("car")
data class CarEntity(
    @Id var id: Long? = null,
    @Column var name: String,
    @Column var manufacturer: String,
)