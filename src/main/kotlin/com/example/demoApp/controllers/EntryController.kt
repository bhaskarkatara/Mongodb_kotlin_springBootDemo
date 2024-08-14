package com.example.demoApp.controllers

import com.example.demoApp.entity.DataModel
import com.example.demoApp.service.ServiceEntry
import com.example.demoApp.service.userService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("entries")
class EntryController {

      // controller -- > service --> repo
    // (just like android, Compose --->viewModel ---> repo )

    @Autowired
    lateinit var serviceEntry : ServiceEntry

    @Autowired
    lateinit var userService: userService

    @GetMapping("{userName}")
    fun getAllEntriesOfUser(@PathVariable userName : String) : ResponseEntity<String>{
         val user = userService.findByUserName(userName)
         val allEntries = user.journalEntries
         return if(allEntries.isNotEmpty()){
             return ResponseEntity("Entry find",HttpStatus.OK)
         }else{
             ResponseEntity("not found ",HttpStatus.NOT_FOUND)
         }
    }

    @PostMapping("{userName}")
    fun addEntries(@RequestBody myEntry: DataModel,@PathVariable userName: String): ResponseEntity<String> {
        return try {
            serviceEntry.saveEntries(myEntry,userName)
            ResponseEntity("Entry added successfully", HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity("Failed to add entry: ${e.message}", HttpStatus.BAD_REQUEST)
        }
    }


    @GetMapping("id/{myId}")
    fun getByID(@PathVariable myId: ObjectId) : Optional<DataModel> {
      return serviceEntry.getById(myId)
    }

//    @PutMapping("id/{id}")
//    fun updateById(@PathVariable id: ObjectId, @RequestBody newEntry: DataModel): ResponseEntity<String> {
//        val oldEntry = serviceEntry.getById(id).orElse(null)
//        return if (oldEntry != null) {
//            oldEntry.name = newEntry.name.ifEmpty { oldEntry.name }
//            oldEntry.content = newEntry.content
//            serviceEntry.saveEntries(oldEntry, user) // Save the updated entry
//            ResponseEntity("Entry updated successfully", HttpStatus.OK)
//        } else {
//            ResponseEntity("Entry not found", HttpStatus.NOT_FOUND)
//        }
//    }


    @DeleteMapping("id/{userName}{myId}")
    fun deleteById(@PathVariable myId: ObjectId,@PathVariable userName: String) :Boolean{
       serviceEntry.deleteById(myId,userName)
        return true
    }
}