package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getQuizQuestionById(
    repository: QuizQuestionRepository
) {
    get(path = "/quiz/questions/{questionId}") {
        val id = call.parameters["questionId"]
        if (id.isNullOrBlank()) {
            call.respond(
                message = "Question Id needed!",
                status = HttpStatusCode.BadRequest
            )
            return@get
        }
        val question = repository.getQuestionById(id)
        if (question != null) {
            call.respond(
                status = HttpStatusCode.OK,
                message = question
            )
        } else {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = "No Quiz Question"
            )
        }
    }
}