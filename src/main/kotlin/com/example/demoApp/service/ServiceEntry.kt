package com.example.demoApp.service

import com.example.demoApp.entity.DataModel
import com.example.demoApp.repository.DemoEntryRepo
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class ServiceEntry {

    // dependency injection
    @Autowired
    lateinit var  demoEntryRepo: DemoEntryRepo

    @Autowired
    lateinit var userService: userService

    fun saveEntries(entry: DataModel, userName: String){
        val user = userService.findByUserName(userName)
       val saved =  demoEntryRepo.save(entry)
        user.journalEntries.add(saved)
        userService.saveEntries(user)
    }

    fun getAll(): List<DataModel> = demoEntryRepo.findAll()

    fun getById(id: ObjectId): Optional<DataModel> = demoEntryRepo.findById(id)

    fun deleteById(id: ObjectId, userName: String) {
        val user = userService.findByUserName(userName)
        // Remove the entry with the given id from the user's journalEntries list
        user.journalEntries.removeIf { it.id == id }
        // Save the updated user object to persist the change
        userService.saveEntries(user)
        // Delete the entry from the demoEntryRepo by its id
        demoEntryRepo.deleteById(id)
    }
}