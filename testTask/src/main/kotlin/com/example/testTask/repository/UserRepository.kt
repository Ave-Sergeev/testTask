package com.example.testTask.repository

import com.example.testTask.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Long> {
    //Создаем юзверя
    fun save(user: User)

    //Возвращаем всех юзеров
    override fun  findAll(): List<User>

    //Возвращаем юзера по Id
    override fun findById(id: Long): Optional<User>
}