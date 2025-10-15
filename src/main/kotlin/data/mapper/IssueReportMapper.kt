package com.kaaneneskpc.data.mapper

import com.kaaneneskpc.data.database.entity.IssueReportEntity
import com.kaaneneskpc.domain.model.IssueReport


fun IssueReportEntity.toIssueReport() = IssueReport(
    id = _id,
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestamp
)

fun IssueReport.toIssueReportEntity() = IssueReportEntity(
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestamp
)