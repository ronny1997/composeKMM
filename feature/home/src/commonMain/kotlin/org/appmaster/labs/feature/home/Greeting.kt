package org.appmaster.labs.feature.home

import org.appmaster.labs.feature.home.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}