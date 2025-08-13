package com.kaaneneskpc

import com.kaaneneskpc.presentation.config.configureLogging
import com.kaaneneskpc.presentation.config.configureRouting
import com.kaaneneskpc.presentation.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureLogging()
    configureSerialization()
    configureRouting()
}
