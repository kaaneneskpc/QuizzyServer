package com.kaaneneskpc.domain.repository

import com.kaaneneskpc.domain.model.QuizQuestion

interface QuizQuestionRepository {
    suspend fun upsertQuestion(question: QuizQuestion)
    suspend fun getAllQuestions(topicCode: Int?, limit: Int?): List<QuizQuestion>
    suspend fun getQuestionById(id: String): QuizQuestion?
    suspend fun deleteQuestionById(id: String): Boolean
}