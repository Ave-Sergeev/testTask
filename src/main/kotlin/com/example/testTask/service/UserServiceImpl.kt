package com.example.testTask.service

import com.example.testTask.models.User
import com.example.testTask.repository.UserRepository
import java.util.*

class UserServiceImpl (private val userRepository: UserRepository): BaseService<User> {
    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun save(user: User): User? {
        return try { userRepository.save(user) } catch(e: ExecutionExeption) { null }
    }

    override fun findById(id: Long): Optional<User> {
        val userZero = userRepository.findById(id)
        return if (userZero.isEmpty) null else userZero.get()
    }
}