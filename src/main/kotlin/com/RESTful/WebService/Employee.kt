package com.RESTful.WebService

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employee")
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "user_name", unique = true, nullable = false)
    val userName: String?,
    @Column(name = "first_name", nullable = false)
    val firstName: String?,
    @Column(name = "last_name", nullable = false)
    val lastName: String?,
    @Column(name = "email_address", nullable = false)
    val email: String?,
    @Column(name = "day_of_birth", nullable = false)
    val birthday: LocalDate?
)