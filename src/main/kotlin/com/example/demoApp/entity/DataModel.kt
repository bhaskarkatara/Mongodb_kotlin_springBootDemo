package com.example.demoApp.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
// document ->row
@Document(collection = "demo_entries")
data class DataModel(
    @Id
    val id: ObjectId? = null, // Nullable for auto-generated IDs
    var name :String,
    var content :String
)
