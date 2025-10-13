package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.DataError
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions(
    repository: QuizQuestionRepository
) {
    get(path = "/quiz/questions") {
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull()
        val limit = call.queryParameters["limit"]?.toIntOrNull()
        repository.getAllQuestions(topicCode, limit)
            .onSuccess { quizQuestions ->
                call.respond(
                    message = quizQuestions,
                    status = HttpStatusCode.OK
                )
            }.onFailure { error ->
                respondWithError(error)
            }
        }
}