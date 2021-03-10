package com.example.testTask.controllers

import com.example.testTask.models.User
import com.example.testTask.service.UserServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/api/")
class UserController(val userServiceImpl: UserServiceImpl) {

    //Принимаем на вход JSON, по которому в БД создаем пользователя
    @PostMapping(value = ["/users/create"])
    fun createUser(@RequestBody user: User): ResponseEntity<*>? {
        userServiceImpl.save(user)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }

    //Возвращаем список всех пользователей из БД приложения
    @GetMapping(value = ["/users/getAll"])
    fun getAllUser(): ResponseEntity<List<User>>? {
        val users: List<User> = userServiceImpl.findAll() as List<User>
        return ResponseEntity<List<User>>(users, HttpStatus.OK)
    }

    //Возвращаем прользователя по заданному id
    @GetMapping(value = ["/users/{id}"])
    fun searchUser(@PathVariable(name = "id") id: Long): ResponseEntity<User> {
        val user: User = userServiceImpl.findById(id)
        return ResponseEntity<User>(user, HttpStatus.OK)
    }
}