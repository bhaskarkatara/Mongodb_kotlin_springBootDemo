package com.example.demoApp.controllers

import com.example.demoApp.entity.UserDataModel
import com.example.demoApp.service.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("user")
class userController {

    @Autowired
    lateinit var userService: userService

    @GetMapping
    fun getAllUser() : List<UserDataModel>{
        return userService.getAll()
    }

    @PostMapping
    fun createUser(@RequestBody user: UserDataModel): ResponseEntity<String> {
        userService.saveEntries(user)
        return ResponseEntity("User created successfully", HttpStatus.CREATED)
    }
    @PutMapping
    fun updateUser(@RequestBody user: UserDataModel): ResponseEntity<String> {
        val userInDb = userService.findByUserName(user.userName)
        return run {
            userInDb.userName = user.userName
            userInDb.password = user.password
            userService.saveEntries(userInDb)
            ResponseEntity("User updated successfully", HttpStatus.OK)
        }
    }


}