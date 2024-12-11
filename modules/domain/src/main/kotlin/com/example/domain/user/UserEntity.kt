package com.example.domain.user

import com.example.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
data class User(
    @Column(name = "username") val username: String,
    @Column(name = "email") val email: String
) : BaseEntity()