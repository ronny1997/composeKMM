package org.appmaster.labs.domain.fuelstation.datasource.allFuelStation

import org.appmaster.labs.domain.fuelstation.usecase.common.model.FuelStation

interface AllFuelStationRepository {
    suspend fun getAllFuelStation(): FuelStation
}