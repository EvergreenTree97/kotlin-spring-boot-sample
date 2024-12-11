package com.example.common

data class ApiServerResponse<T>(
    val data: T?,
)

fun <T> T.toApiServerResponse() = ApiServerResponse<T>(this)