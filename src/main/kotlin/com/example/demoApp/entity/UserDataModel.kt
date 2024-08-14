package com.example.demoApp.entity

import org.bson.types.ObjectId
import org.jetbrains.annotations.NotNull
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexOptions.Unique
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Field
//import org.springframework.stereotype.Indexed
import org.springframework.data.mongodb.core.index.Indexed

// document ->row
@Document(collection = "users")
//@Metadata
data class UserDataModel(
    @Id
    var id: ObjectId = ObjectId.get(),

    @Indexed(unique = true)
    @NotNull
     var userName : String,
    @NotNull
     var password : String,

     @DBRef
    var journalEntries : List<DataModel> = listOf()

)