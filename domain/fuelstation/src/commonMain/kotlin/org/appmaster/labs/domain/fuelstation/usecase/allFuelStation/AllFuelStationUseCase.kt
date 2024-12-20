package org.appmaster.labs.domain.fuelstation.usecase.allFuelStation

import org.appmaster.labs.domain.fuelstation.datasource.allFuelStation.AllFuelStationRepository
import org.appmaster.labs.domain.fuelstation.usecase.common.model.Station
import org.master.labs.core.domain.AsyncUseCase

class AllFuelStationUseCase(
    private val allFuelStationRepository: AllFuelStationRepository,
) : AsyncUseCase<List<Station>, Unit>() {
    override suspend fun runInBackground(params: Unit): List<Station> {
        return allFuelStationRepository.getAllFuelStation().stationList ?: emptyList()
    }
}