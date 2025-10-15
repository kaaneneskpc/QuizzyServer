package com.kaaneneskpc.data.repository

import com.kaaneneskpc.data.database.entity.IssueReportEntity
import com.kaaneneskpc.data.mapper.toIssueReport
import com.kaaneneskpc.data.mapper.toIssueReportEntity
import com.kaaneneskpc.domain.model.IssueReport
import com.kaaneneskpc.domain.repository.IssueReportRepository
import com.kaaneneskpc.domain.util.DataError
import com.kaaneneskpc.domain.util.Result
import com.kaaneneskpc.presentation.util.Constant.ISSUE_REPORTS_COLLECTION_NAME
import com.mongodb.client.model.Filters
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class IssueReportRepositoryImpl(
    mongoDatabase: MongoDatabase
): IssueReportRepository {

    private val reportCollection = mongoDatabase
        .getCollection<IssueReportEntity>(ISSUE_REPORTS_COLLECTION_NAME)

    override suspend fun getAllIssueReports(): Result<List<IssueReport>, DataError> {
        return try {
            val reports = reportCollection
                .find()
                .map { it.toIssueReport() }
                .toList()
            if (reports.isNotEmpty()) {
                Result.Success(reports)
            } else {
                Result.Failure(DataError.NotFound)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }

    override suspend fun insertIssueReport(report: IssueReport): Result<Unit, DataError> {
        return try {
            reportCollection.insertOne(report.toIssueReportEntity())
            Result.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }

    override suspend fun deleteIssueReportById(id: String?): Result<Unit, DataError> {
        if (id.isNullOrBlank()) {
            return Result.Failure(DataError.Validation)
        }
        return try {
            val filterQuery = Filters.eq(
                IssueReportEntity::_id.name, id
            )
            val deleteResult = reportCollection.deleteOne(filterQuery)
            if (deleteResult.deletedCount > 0) {
                Result.Success(Unit)
            } else {
                Result.Failure(DataError.NotFound)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }
}