package com.example.apiserver.controller.user.request

data class UserUpdateRequest(
    val username: String?,
    val email: String?,
)