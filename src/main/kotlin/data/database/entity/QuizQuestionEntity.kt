package com.kaaneneskpc.data.database.entity

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class QuizQuestionEntity(
    @BsonId
    val _id: String = ObjectId().toString(),
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val explanation: String,
    val topicCode: Int
)