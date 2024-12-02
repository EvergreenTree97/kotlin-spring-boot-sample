package com.example.apiserver.error

data class ApiServerException(
    override val message: String
) : Exception(message)