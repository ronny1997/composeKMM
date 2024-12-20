package org.appmaster.labs.feature.home

import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppDestination() {
    val vm: AppViewModel = koinViewModel()
    AppScreen(
        state = vm.viewState,
        effectFlow = vm.effect,
        onEventSend = { vm.setEvent(it) },
        onNavigationRequested = {
            when (it) {
                is AppContract.Effect.Navigation.ToDetail -> {}
            }
        }
    )
}