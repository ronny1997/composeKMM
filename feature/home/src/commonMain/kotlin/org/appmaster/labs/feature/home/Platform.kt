package org.appmaster.labs.feature.home

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform