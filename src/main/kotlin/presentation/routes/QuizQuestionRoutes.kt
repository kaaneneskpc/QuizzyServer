package com.kaaneneskpc.presentation.routes

import com.kaaneneskpc.domain.model.QuizQuestion
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.presentation.routes.path.QuizQuestionRoutesPath
import com.kaaneneskpc.presentation.util.respondWithError
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route

fun Route.quizQuestionRoutes(
    repository: QuizQuestionRepository
) {

    post<QuizQuestionRoutesPath> {
        val question = call.receive<QuizQuestion>()
        repository.upsertQuestion(question)
            .onSuccess {
                call.respond(
                    message = "Question added successfully",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    post<QuizQuestionRoutesPath.Bulk> {
        val quizQuestion = call.receive<List<QuizQuestion>>()
        repository.insertQuestionsInBulk(quizQuestion)
            .onSuccess {
                call.respond(
                    message = "Quiz Questions added",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath> { path ->
        repository.getAllQuestions(path.topicCode)
            .onSuccess { questions ->
                call.respond(
                    message = questions,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath.Random> { path ->
        repository.getRandomQuestions(path.topicCode, path.limit)
            .onSuccess { questions ->
                call.respond(
                    message = questions,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath.ById> { path ->
        repository.getQuestionById(path.questionId)
            .onSuccess { question ->
                call.respond(
                    message = question,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<QuizQuestionRoutesPath.ById> { path ->
        repository.deleteQuestionById(path.questionId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

}