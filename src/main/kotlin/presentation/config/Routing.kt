package com.kaaneneskpc.presentation.config

import com.kaaneneskpc.data.database.DatabaseFactory
import com.kaaneneskpc.data.repository.QuizQuestionRepositoryImpl
import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.presentation.root
import com.kaaneneskpc.presentation.routes.quiz_questions.deleteQuizQuestionById
import com.kaaneneskpc.presentation.routes.quiz_questions.getAllQuizQuestions
import com.kaaneneskpc.presentation.routes.quiz_questions.getQuizQuestionById
import com.kaaneneskpc.presentation.routes.quiz_questions.upsertQuizQuestion
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {

    val mongoDatabase = DatabaseFactory.create()
    val quizQuestionRepository: QuizQuestionRepository = QuizQuestionRepositoryImpl(mongoDatabase)

    routing {
        root()
        getAllQuizQuestions(quizQuestionRepository)
        upsertQuizQuestion(quizQuestionRepository)
        getQuizQuestionById(quizQuestionRepository)
        deleteQuizQuestionById(quizQuestionRepository)
    }
}