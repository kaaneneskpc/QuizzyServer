package com.kaaneneskpc.presentation.config

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.presentation.root
import com.kaaneneskpc.presentation.routes.quiz_questions.getAllQuizQuestions
import com.kaaneneskpc.presentation.routes.quiz_questions.upsertQuizQuestion
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        root()
        getAllQuizQuestions()
        upsertQuizQuestion()
    }
}

val quizQuestions = mutableListOf<QuizQuestion>()