package com.example.testTask.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    val firstname: String,
    val lastname: String,

    @JsonIgnore
    val password: String
)