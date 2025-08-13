package com.kaaneneskpc.presentation.routes.quiz_questions

import com.kaaneneskpc.presentation.config.quizQuestions
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions() {
    get(path = "/quiz/questions") {
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull()
        val limit = call.queryParameters["limit"]?.toIntOrNull()
        val filteredQuestions = if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions.take(limit ?: quizQuestions.size)

        }

        if(filteredQuestions.isNotEmpty()) {
            call.respond(
                message = filteredQuestions,
                status = HttpStatusCode.OK
            )
        } else {
            call.respond(
                message = "No Quiz Questions",
                status = HttpStatusCode.NotFound
            )
        }

        call.respond(filteredQuestions)
    }
}