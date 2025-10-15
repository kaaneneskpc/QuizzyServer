package com.kaaneneskpc.presentation.routes

import com.kaaneneskpc.domain.model.QuizTopic
import com.kaaneneskpc.domain.repository.QuizTopicRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.presentation.routes.path.QuizTopicRoutesPath
import com.kaaneneskpc.presentation.util.respondWithError
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route

fun Route.quizTopicRoutes(
    repository: QuizTopicRepository
) {

    post<QuizTopicRoutesPath> {
        val quizTopic = call.receive<QuizTopic>()
        repository.upsertTopic(quizTopic)
            .onSuccess {
                call.respond(
                    message = "Quiz Topic added",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizTopicRoutesPath> {
        repository.getAllTopics()
            .onSuccess { topics ->
                call.respond(
                    message = topics,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizTopicRoutesPath.ById> { path ->
        repository.getTopicById(path.topicId)
            .onSuccess { quizTopic ->
                call.respond(
                    message = quizTopic,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<QuizTopicRoutesPath.ById> { path ->
        repository.deleteTopicById(path.topicId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }
}