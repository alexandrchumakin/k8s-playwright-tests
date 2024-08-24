package org.achumkin

fun getRequiredEnv(envName: String): String = System.getenv(envName)
    ?: error("'$envName' environment variable is required")
