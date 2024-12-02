package com.example.apiserver.controller.user

import com.example.apiserver.controller.user.request.UserCreateRequest
import com.example.apiserver.controller.user.request.UserUpdateRequest
import com.example.apiserver.controller.user.response.UserResponse
import com.example.apiserver.error.ApiServerException
import com.example.domain.user.UserRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    //private val eventPublisher: ApplicationEventPublisher,
) {
    @Cacheable(value = ["users"], key = "#id")
    @Transactional(readOnly = true)
    fun getUser(id: Long): UserResponse {
        val user = userRepository.findByIdOrNull(id) ?: throw ApiServerException("id-$id user 를 찾을 수 없습니다.")
        return UserResponse.fromEntity(user)
    }

    @Transactional
    fun createUser(request: UserCreateRequest): UserResponse {
        val user = userRepository.save(request.toEntity()).also {
            //eventPublisher.publishEvent(UserCreatedEventPayload(it.id))
        }
        return UserResponse.fromEntity(user)
    }

    @Transactional
    fun updateUser(id: Long, request: UserUpdateRequest): UserResponse {
        val user = userRepository.findByIdOrNull(id) ?: throw ApiServerException("id-$id user 를 찾을 수 없습니다.")
        //eventPublisher.publishEvent(UserUpdatedEventPayload(user.id))
        val savedUser = userRepository.save(
            user.copy(
                username = user.username,
                email = user.email,
            )
        )
        return UserResponse.fromEntity(savedUser)
    }

    @CacheEvict(value = ["users"], key = "#id")
    fun cacheEvict(id: Long) {
    }
}