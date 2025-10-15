package com.kaaneneskpc.presentation.routes

import com.kaaneneskpc.domain.model.IssueReport
import com.kaaneneskpc.domain.repository.IssueReportRepository
import com.kaaneneskpc.domain.util.onFailure
import com.kaaneneskpc.domain.util.onSuccess
import com.kaaneneskpc.presentation.routes.path.IssueReportRoutesPath
import com.kaaneneskpc.presentation.util.respondWithError
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.resources.delete
import io.ktor.server.resources.get
import io.ktor.server.resources.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Route

fun Route.issueReportRoutes(
    repository: IssueReportRepository
) {

    post<IssueReportRoutesPath> {
        val report = call.receive<IssueReport>()
        repository.insertIssueReport(report)
            .onSuccess {
                call.respond(
                    message = "Report submitted successfully",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<IssueReportRoutesPath> {
        repository.getAllIssueReports()
            .onSuccess { reports ->
                call.respond(
                    message = reports,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<IssueReportRoutesPath.ById> { path ->
        repository.deleteIssueReportById(path.reportId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }
}