package org.appmaster.labs.composekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform