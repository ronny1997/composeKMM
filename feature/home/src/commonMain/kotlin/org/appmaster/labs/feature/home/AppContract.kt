package org.appmaster.labs.feature.home

import org.master.labs.core.ui.ViewEvent
import org.master.labs.core.ui.ViewSideEffect
import org.master.labs.core.ui.ViewState


class AppContract {
    sealed class Event : ViewEvent {
        data object GetData : Event()

    }

    data class State(
        val loading: Boolean = false,
        val message: String? = null,
    ) : ViewState

    sealed class Effect : ViewSideEffect {

        sealed class Navigation : Effect() {
            data object ToDetail : Navigation()

        }
    }
}