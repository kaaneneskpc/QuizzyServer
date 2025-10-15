package com.kaaneneskpc.presentation.config

import com.kaaneneskpc.presentation.validator.validateIssueReport
import com.kaaneneskpc.presentation.validator.validateQuizQuestion
import com.kaaneneskpc.presentation.validator.validateQuizTopic
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureValidation() {
    install(RequestValidation) {
        validateQuizQuestion()
        validateQuizTopic()
        validateIssueReport()
    }
}