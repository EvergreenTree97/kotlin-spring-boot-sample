package com.example.apiserver.clients.randomuser


import org.springframework.stereotype.Component

@Component
class RandomUserClient(
    private val randomUserApi: RandomUserApi,
) {
    fun getRandomUser(): String {
        val randomUser = randomUserApi.getRandomUser().results.first()
        return "${randomUser.name.first} ${randomUser.name.last}"
    }
}