package com.example.testTask.service

import com.example.testTask.models.User
import com.example.testTask.repository.UserRepository
import java.util.*

class UserServiceImpl (private val userRepository: UserRepository): BaseService<User> {
    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun save(user: User) {
        userRepository.save(user)
    }

    override fun findById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }
}