package com.kaaneneskpc.data.repository

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.util.Constant.QUESTIONS_COLLECTION_NAME
import com.mongodb.kotlin.client.coroutine.MongoDatabase

class QuizQuestionRepositoryImpl(
    mongoDatabase: MongoDatabase
) : QuizQuestionRepository {

    val questionCollection = mongoDatabase.getCollection<QuizQuestion>(QUESTIONS_COLLECTION_NAME)

    private val quizQuestions = mutableListOf<QuizQuestion>()

    override suspend fun upsertQuestion(question: QuizQuestion) {
        questionCollection.insertOne(question)
    }

    override suspend fun getAllQuestions(
        topicCode: Int?,
        limit: Int?
    ): List<QuizQuestion> {
        return if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions.take(limit ?: quizQuestions.size)

        }
    }

    override suspend fun getQuestionById(id: String): QuizQuestion? {
        return quizQuestions.find { it.id == id }
    }

    override suspend fun deleteQuestionById(id: String): Boolean {
        return quizQuestions.removeIf { it.id == id }
    }
}