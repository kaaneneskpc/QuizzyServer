package com.kaaneneskpc.presentation.validator

import com.kaaneneskpc.domain.model.IssueReport
import io.ktor.server.plugins.requestvalidation.*

fun RequestValidationConfig.validateIssueReport() {

    val emailRegex = Regex(pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")

    validate<IssueReport> { issueReport ->
        when {
            issueReport.questionId.isBlank() -> {
                ValidationResult.Invalid(
                    reason = "Question ID must not be empty"
                )
            }

            issueReport.issueType.isBlank() -> {
                ValidationResult.Invalid(
                    reason = "Issue type must not be empty"
                )
            }

            issueReport.timestamp.isBlank() -> {
                ValidationResult.Invalid(
                    reason = "Timestamp must not be empty"
                )
            }

            issueReport.additionalComment != null && issueReport.additionalComment.length < 5 -> {
                ValidationResult.Invalid(
                    reason = "Additional Comment must be at least 5 characters long."
                )
            }

            issueReport.userEmail != null && !issueReport.userEmail.matches(emailRegex) -> {
                ValidationResult.Invalid(
                    reason = "Invalid email format"
                )
            }

            else -> {
                ValidationResult.Valid
            }
        }
    }
}