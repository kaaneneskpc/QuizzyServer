package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
import io.ktor.http.HttpStatusCode
import io.ktor.server.resources.get
import io.ktor.server.response.respond
import io.ktor.server.routing.Route

fun Route.getQuizQuestionById(
    repository: QuizQuestionRepository
) {
    get<QuizQuestionRoutesPath.ById> { path ->
        repository.getQuestionById(path.questionId)
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