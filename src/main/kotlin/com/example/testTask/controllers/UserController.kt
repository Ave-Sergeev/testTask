package com.example.testTask.controllers

import com.example.testTask.models.User
import com.example.testTask.service.UserServiceImpl
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/")
class UserController(val userServiceImpl: UserServiceImpl) {

    //Принимаем на вход JSON, по которому в БД создаем пользователя
    @PostMapping(value = ["/users/create"])
    fun createUser(@RequestBody user: User): User {
        return userServiceImpl.save(user)
    }

    //Возвращаем список всех пользователей из БД приложения
    @GetMapping(value = ["/users/getAll"])
    fun getAllUser(): List<User> {
        return userServiceImpl.findAll()
    }

    //Возвращаем прользователя по заданному id
    @GetMapping(value = ["/users/{id}"])
    fun searchUser(@PathVariable(name = "id") id: Long): User {
        return userServiceImpl.findById(id)
    }
}
