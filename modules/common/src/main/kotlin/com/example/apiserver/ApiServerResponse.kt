package com.example.apiserver

data class ApiServerResponse<T>(
    val data: T?,
)

fun <T> T.toApiServerResponse() = ApiServerResponse<T>(this)