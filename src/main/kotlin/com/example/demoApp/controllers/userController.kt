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
    lateinit var userService : userService

    @GetMapping
    fun getAllUser() : List<UserDataModel>{
        return userService.getAll()
    }

    @PostMapping
    fun createUser(@RequestBody user: UserDataModel): ResponseEntity<String> {
        try{
            userService.saveEntries(user)
            return ResponseEntity("User created successfully", HttpStatus.CREATED)
        }catch (e:Exception){
            return ResponseEntity("error",HttpStatus.BAD_REQUEST)
        }

    }
    @PutMapping("{userName}")

    fun updateUser(@RequestBody user: UserDataModel,@PathVariable userName:String): ResponseEntity<String> {
        val userInDb = userService.findByUserName(userName)
        return run {
            userInDb.userName = user.userName
            userInDb.password = user.password
            userService.saveEntries(userInDb)
            ResponseEntity("User updated successfully", HttpStatus.OK)
        }
    }



}