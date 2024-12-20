package org.appmaster.labs.data.fuelstation.datasource.allFuelStation

import org.appmaster.labs.data.fuelstation.common.model.FuelStationDto

interface AllFuelStationDataSource {
    suspend fun getAllFuelStation(): FuelStationDto
}