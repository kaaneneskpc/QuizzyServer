package com.kaaneneskpc.di


import com.kaaneneskpc.data.database.DatabaseFactory
import com.kaaneneskpc.data.repository.IssueReportRepositoryImpl
import com.kaaneneskpc.data.repository.QuizQuestionRepositoryImpl
import com.kaaneneskpc.data.repository.QuizTopicRepositoryImpl
import com.kaaneneskpc.domain.repository.IssueReportRepository
import com.kaaneneskpc.domain.repository.QuizQuestionRepository
import com.kaaneneskpc.domain.repository.QuizTopicRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {

    single { DatabaseFactory.create() }
    singleOf(::QuizQuestionRepositoryImpl).bind<QuizQuestionRepository>()
    singleOf(::QuizTopicRepositoryImpl).bind<QuizTopicRepository>()
    singleOf(::IssueReportRepositoryImpl).bind<IssueReportRepository>()

}