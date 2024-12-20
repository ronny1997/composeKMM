package org.appmaster.labs.composekmm

import androidx.compose.ui.window.ComposeUIViewController
import org.appmaster.labs.composekmm.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure =  {
        initKoin()
    }
) { App() }