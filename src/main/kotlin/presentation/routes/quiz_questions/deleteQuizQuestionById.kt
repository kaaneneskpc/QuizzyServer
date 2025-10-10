package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete

fun Route.deleteQuizQuestionById(
    repository: QuizQuestionRepository
) {
    delete(path = "/quiz/questions/{questionId}") {
        val id = call.parameters["questionId"]
        if (id.isNullOrBlank()) {
            call.respond(
                message = "Question Id needed!",
                status = HttpStatusCode.BadRequest
            )
            return@delete
        }
        val isDeleted = repository.deleteQuestionById(id)
        if (isDeleted) {
            call.respond(HttpStatusCode.NoContent)
        } else {
            call.respond(
                message = "No Question to delete",
                status = HttpStatusCode.NotFound
            )
        }
    }
}