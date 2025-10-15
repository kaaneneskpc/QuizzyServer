package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
import io.ktor.http.HttpStatusCode
import io.ktor.server.resources.get
import io.ktor.server.response.respond
import io.ktor.server.routing.Route

fun Route.getAllQuizQuestions(
    repository: QuizQuestionRepository
) {
    get<QuizQuestionRoutesPath> { path ->
        repository.getAllQuestions(path.topicCode, path.limit)
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