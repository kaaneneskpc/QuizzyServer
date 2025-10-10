package com.kaaneneskpc.data.database

import com.kaaneneskpc.util.Constant.MONGO_DATABASE_NAME
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object DatabaseFactory {
    fun create(): MongoDatabase {
        val connectionString = System.getenv("MONGO_URL") ?: throw IllegalArgumentException("MONGO_URL is not set")
        val databaseName = MONGO_DATABASE_NAME
        val mongoClient = MongoClient.create(connectionString)
        return mongoClient.getDatabase(databaseName)
    }
}