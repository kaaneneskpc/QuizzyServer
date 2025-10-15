package com.kaaneneskpc.domain.repository

import com.kaaneneskpc.domain.model.IssueReport
import com.kaaneneskpc.domain.util.DataError
import com.kaaneneskpc.domain.util.Result

interface IssueReportRepository {
    suspend fun getAllIssueReports(): Result<List<IssueReport>, DataError>
    suspend fun insertIssueReport(report: IssueReport): Result<Unit, DataError>
    suspend fun deleteIssueReportById(id: String?): Result<Unit, DataError>
}