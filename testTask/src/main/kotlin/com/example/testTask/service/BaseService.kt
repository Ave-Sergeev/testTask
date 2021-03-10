package com.example.testTask.service

interface BaseService<T> {
    fun save(user: T)

    fun findAll(): List<T>

    fun findById(id: Long)
}