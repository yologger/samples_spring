package com.yologger.samples.webflux_kotlin.controller

data class AddMemberRequest(
    val email: String,
    val name: String,
    val password: String
)
