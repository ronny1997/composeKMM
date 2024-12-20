package org.appmaster.labs.data.fuelstation.repository.allFuelStation


import org.appmaster.labs.data.fuelstation.common.map.toDomain
import org.appmaster.labs.data.fuelstation.datasource.allFuelStation.AllFuelStationDataSource
import org.appmaster.labs.domain.fuelstation.datasource.allFuelStation.AllFuelStationRepository
import org.appmaster.labs.domain.fuelstation.usecase.common.model.FuelStation
import org.master.labs.core.data.BaseRepository

class AllFuelStationRepositoryImpl(
    private val allFuelStationDataSource: AllFuelStationDataSource
) : AllFuelStationRepository, BaseRepository() {
    override suspend fun getAllFuelStation(): FuelStation {
        return safeExecution {
            allFuelStationDataSource.getAllFuelStation()
        }.toDomain()
    }
}