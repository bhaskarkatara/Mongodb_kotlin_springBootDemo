package com.example.demoApp.repository

import com.example.demoApp.entity.DataModel
import com.example.demoApp.entity.UserDataModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface userRepo: MongoRepository<UserDataModel,ObjectId>  {

}
