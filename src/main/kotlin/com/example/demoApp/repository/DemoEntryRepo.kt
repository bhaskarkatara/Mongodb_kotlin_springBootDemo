package com.example.demoApp.repository

import com.example.demoApp.entity.DataModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface DemoEntryRepo: MongoRepository<DataModel,ObjectId>  {

}
