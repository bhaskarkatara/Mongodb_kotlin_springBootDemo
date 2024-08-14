package com.example.demoApp.service

import com.example.demoApp.entity.DataModel
import com.example.demoApp.entity.UserDataModel
import com.example.demoApp.repository.DemoEntryRepo
import com.example.demoApp.repository.userRepo
import org.apache.catalina.User
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class userService {

    // dependency injection
    @Autowired
    lateinit var  userRepo: userRepo

    fun saveEntries(entry: UserDataModel){
        userRepo.save(entry)
    }

    fun getAll(): List<UserDataModel> = userRepo.findAll()

    fun getById(id: ObjectId): Optional<UserDataModel> = userRepo.findById(id)

    fun deleteById(id: ObjectId) = userRepo.deleteById(id)

    fun findByUserName(userName : String):UserDataModel{
     return userRepo.findByUserName(userName)
    }
}