package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
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
         repository.getQuestionById(id)
             .onSuccess { question -> 
                 call.respond(
                     status = HttpStatusCode.OK,
                     message = question
                 )
             }.onFailure { error ->
                 respondWithError(error)
             }
    }
}