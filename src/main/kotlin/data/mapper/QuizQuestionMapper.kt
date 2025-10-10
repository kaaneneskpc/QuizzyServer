package com.kaaneneskpc.data.mapper

import com.kaaneneskpc.data.database.entity.QuizQuestionEntity
import com.kaaneneskpc.domain.model.QuizQuestion


fun QuizQuestionEntity.toQuizQuestion() = QuizQuestion(
    id = _id,
    question = question,
    correctAnswer = correctAnswer,
    incorrectAnswers = incorrectAnswers,
    explanation = explanation,
    topicCode = topicCode
)

fun QuizQuestion.toQuizQuestionEntity() = QuizQuestionEntity(
    question = question,
    correctAnswer = correctAnswer,
    incorrectAnswers = incorrectAnswers,
    explanation = explanation,
    topicCode = topicCode
)