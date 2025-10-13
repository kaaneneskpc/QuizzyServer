package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
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
            .onSuccess {
                call.respond(
                    message = "Question added successfully!",
                    status = HttpStatusCode.Created
                )
            }.onFailure { error ->
                respondWithError(error)
            }
    }
}