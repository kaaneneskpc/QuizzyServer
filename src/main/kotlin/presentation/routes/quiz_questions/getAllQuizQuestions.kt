package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.presentation.config.quizQuestions
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions() {
    get(path = "/quiz/questions") {
        call.respond(quizQuestions)
    }
}