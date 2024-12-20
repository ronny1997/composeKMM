package org.appmaster.labs.feature.home.list

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.appmaster.labs.domain.fuelstation.usecase.allFuelStation.AllFuelStationUseCase
import org.master.labs.core.ui.BaseViewModel

class FuelStationListViewModel(
    private val allFuelStationUseCase: AllFuelStationUseCase,
) : BaseViewModel<FuelStationListContract.Event, FuelStationListContract.State, FuelStationListContract.Effect>() {
    init {
        getAllFuelStation()
    }

    override fun setInitialState(): FuelStationListContract.State =
        FuelStationListContract.State(loading = true)

    override fun handleEvents(event: FuelStationListContract.Event) {
        when (event) {
            is FuelStationListContract.Event.NavigateToFilter -> {
                setEffect { FuelStationListContract.Effect.Navigation.ToFilter }
            }

            is FuelStationListContract.Event.NavigateToDetail -> {
                setEffect { FuelStationListContract.Effect.Navigation.ToDetail(event.id) }
            }
        }
    }

    private fun getAllFuelStation() {
        viewModelScope.launch {
            allFuelStationUseCase().onSuccess {
                setState { copy(loading = false, stationList = it) }
            }.onFailure {
                setState { copy(loading = false, errorMessage = it.message) }
            }
        }
    }

}