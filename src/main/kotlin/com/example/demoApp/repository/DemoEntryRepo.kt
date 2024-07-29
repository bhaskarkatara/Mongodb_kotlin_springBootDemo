package com.example.demoApp.repository

import com.example.demoApp.controllers.DataModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface DemoEntryRepo: MongoRepository<DataModel,ObjectId>  {

}
