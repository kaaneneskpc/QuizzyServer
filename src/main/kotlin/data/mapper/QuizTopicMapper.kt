package com.kaaneneskpc.data.mapper

import com.kaaneneskpc.data.database.entity.QuizTopicEntity
import com.kaaneneskpc.domain.model.QuizTopic

fun QuizTopicEntity.toQuizTopic() = QuizTopic(
    id = _id,
    name = name,
    imageUrl = imageUrl,
    code = code
)

fun QuizTopic.toQuizTopicEntity() = QuizTopicEntity(
    name = name,
    imageUrl = imageUrl,
    code = code
)