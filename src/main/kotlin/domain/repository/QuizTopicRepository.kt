package com.kaaneneskpc.domain.repository

import com.kaaneneskpc.domain.model.QuizTopic
import com.kaaneneskpc.domain.util.DataError
import com.kaaneneskpc.domain.util.Result

interface QuizTopicRepository {
    suspend fun getAllTopics(): Result<List<QuizTopic>, DataError>
    suspend fun upsertTopic(topic: QuizTopic): Result<Unit, DataError>
    suspend fun getTopicById(id: String?): Result<QuizTopic, DataError>
    suspend fun deleteTopicById(id: String?): Result<Unit, DataError>
}