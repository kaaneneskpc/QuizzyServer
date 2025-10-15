package com.kaaneneskpc.presentation.config

import com.kaaneneskpc.domain.repository.IssueReportRepository
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.repository.QuizTopicRepository
import com.kaaneneskpc.presentation.routes.issueReportRoutes
import com.kaaneneskpc.presentation.routes.quizQuestionRoutes
import com.kaaneneskpc.presentation.routes.quizTopicRoutes
import com.kaaneneskpc.presentation.routes.root
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.resources.Resources
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    install(Resources)

    val quizQuestionRepository: QuizQuestionRepository by inject()
    val quizTopicRepository: QuizTopicRepository by inject()
    val issueReportRepository: IssueReportRepository by inject()

    routing {
        root()
        quizQuestionRoutes(quizQuestionRepository)
        quizTopicRoutes(quizTopicRepository)
        issueReportRoutes(issueReportRepository)
    }
}