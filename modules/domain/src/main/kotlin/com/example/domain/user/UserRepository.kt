package com.example.domain.user

import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface UserRepository : JpaRepository<User, Long>