package org.appmaster.labs.feature.home.list

import org.appmaster.labs.domain.fuelstation.usecase.common.model.Station
import org.master.labs.core.ui.ViewEvent
import org.master.labs.core.ui.ViewSideEffect
import org.master.labs.core.ui.ViewState

class FuelStationListContract {
    sealed class Event : ViewEvent {
        data object NavigateToFilter : Event()
        data class NavigateToDetail(val id: String) : Event()

    }

    data class State(
        val loading: Boolean = false,
        val stationList: List<Station> = emptyList(),
        val errorMessage: String? = null,
    ) : ViewState

    sealed class Effect : ViewSideEffect {

        sealed class Navigation : Effect() {
            data class ToDetail(val id: String) : Navigation()
            data object ToFilter : Navigation()
        }
    }
}