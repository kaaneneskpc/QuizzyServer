package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.util.respondWithError
import io.ktor.http.HttpStatusCode
import io.ktor.server.resources.delete
import io.ktor.server.response.respond
import io.ktor.server.routing.Route

fun Route.deleteQuizQuestionById(
    repository: QuizQuestionRepository
) {
    delete<QuizQuestionRoutesPath.ById> { path ->
        repository.deleteQuestionById(path.questionId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }.onFailure { error ->
                respondWithError(error)
            }
    }
}