package org.appmaster.labs.feature.home

import androidx.compose.runtime.Composable

interface BackHandlerCompose {
    var onBackPress: (() -> Unit)?
    fun unregister()
    @Composable
    fun HandleBackPress()
}

expect fun getBackHandler(): BackHandlerCompose