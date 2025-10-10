package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.upsertQuizQuestion(
    repository: QuizQuestionRepository
) {
    post(path = "/quiz/questions") {
        val question = call.receive<QuizQuestion>()
        repository.upsertQuestion(question)
        call.respond(
            message = "Question added successfully!",
            status = HttpStatusCode.Created
        )
    }
}