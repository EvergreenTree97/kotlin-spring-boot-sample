package com.example.apiserver.controller.user.request

import com.example.domain.user.User

data class UserCreateRequest(
    val username: String,
    val email: String
) {
    fun toEntity() = User(
        username = username,
        email = email
    )
}