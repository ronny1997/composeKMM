package org.appmaster.labs.feature.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.appmaster.labs.domain.fuelstation.usecase.allFuelStation.AllFuelStationUseCase

import org.master.labs.core.ui.BaseViewModel

class AppViewModel(
    private val allFuelStationUseCase: AllFuelStationUseCase,
) : BaseViewModel<AppContract.Event, AppContract.State, AppContract.Effect>() {

    override fun setInitialState(): AppContract.State = AppContract.State(
        loading = false,
        message = null,
    )

    override fun handleEvents(event: AppContract.Event) {
        when (event) {
            AppContract.Event.GetData -> getAllFuelStation()
        }
    }

    private fun getAllFuelStation() {

    }
}