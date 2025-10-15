package com.kaaneneskpc.data.database.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class QuizTopicEntity(
    @BsonId
    val _id: String = ObjectId().toString(),
    val name: String,
    val imageUrl: String,
    val code: Int
)