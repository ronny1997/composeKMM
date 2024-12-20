package org.appmaster.labs.data.fuelstation.common.map

import org.appmaster.labs.data.fuelstation.common.model.FuelStationDto
import org.appmaster.labs.domain.fuelstation.usecase.common.model.FuelStation
import org.appmaster.labs.domain.fuelstation.usecase.common.model.Station

fun FuelStationDto.toDomain(): FuelStation =
    FuelStation(stationList = this.stationDtoList.map { stationDto ->
        Station(
            postalCode = stationDto.postalCode,
            address = stationDto.address,
            schedule = stationDto.schedule,
            latitude = stationDto.latitude,
            longitude = stationDto.longitude,
            locality = stationDto.locality,
            province = stationDto.province,
            municipality = stationDto.municipality,
            dieselPrice = stationDto.dieselPrice,
            gasoline95Price = stationDto.gasoline95Price,
            label = stationDto.label
        )
    })