package com.example.demoApp.service

import com.example.demoApp.controllers.DataModel
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

    fun saveEntries(entry: DataModel): DataModel = demoEntryRepo.save(entry)

    fun getAll(): List<DataModel> = demoEntryRepo.findAll()

    fun getById(id: ObjectId): Optional<DataModel> = demoEntryRepo.findById(id)

    fun deleteById(id: ObjectId) = demoEntryRepo.deleteById(id)
}