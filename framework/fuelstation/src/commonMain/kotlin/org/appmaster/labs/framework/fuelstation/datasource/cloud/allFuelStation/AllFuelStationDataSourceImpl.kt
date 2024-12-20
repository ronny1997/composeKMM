package org.appmaster.labs.framework.fuelstation.datasource.cloud.allFuelStation

import org.appmaster.labs.data.fuelstation.common.model.FuelStationDto
import org.appmaster.labs.data.fuelstation.datasource.allFuelStation.AllFuelStationDataSource
import org.appmaster.labs.framework.fuelstation.datasource.cloud.allFuelStation.api.AllFuelStationApi
import org.appmaster.labs.framework.fuelstation.datasource.cloud.common.map.toData
import org.master.labs.core.framework.BaseCloudDataSource

class AllFuelStationDataSourceImpl(
    private val allFuelStationApi: AllFuelStationApi,
) : AllFuelStationDataSource, BaseCloudDataSource() {
    override suspend fun getAllFuelStation(): FuelStationDto {
        return execute { allFuelStationApi.getAllFuelStation() }.toData()
    }
}