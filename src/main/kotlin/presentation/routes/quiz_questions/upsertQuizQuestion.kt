package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.presentation.config.quizQuestions
import io.ktor.server.request.receive
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post

fun Route.upsertQuizQuestion() {
    post(path = "/quiz/questions") {
        val question = call.receive<QuizQuestion>()
        quizQuestions.add(question)
        call.respondText("Question added successfully!")
    }
}