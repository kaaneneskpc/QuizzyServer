package com.kaaneneskpc

import com.kaaneneskpc.presentation.config.configureKoin
import com.kaaneneskpc.presentation.config.configureLogging
import com.kaaneneskpc.presentation.config.configureRouting
import com.kaaneneskpc.presentation.config.configureSerialization
import com.kaaneneskpc.presentation.config.configureStatusPages
import com.kaaneneskpc.presentation.config.configureValidation
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureLogging()
    configureSerialization()
    configureRouting()
    configureValidation()
    configureStatusPages()
}
