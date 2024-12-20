package org.appmaster.labs.framework.fuelstation.datasource.cloud.common.map

import org.appmaster.labs.data.fuelstation.common.model.FuelStationDto
import org.appmaster.labs.data.fuelstation.common.model.StationDto
import org.appmaster.labs.framework.fuelstation.datasource.cloud.common.model.FuelStationResponse

fun FuelStationResponse.toData(): FuelStationDto = FuelStationDto(
    stationDtoList = this.stationResponseList?.map { stationResponse ->
        StationDto(
            postalCode = stationResponse?.cP ?: "",
            address = stationResponse?.dirección ?: "",
            schedule = stationResponse?.horario ?: "",
            latitude = stationResponse?.latitud ?: "",
            longitude = stationResponse?.longitudWGS84 ?: "",
            locality = stationResponse?.localidad ?: "",
            province = stationResponse?.provincia ?: "",
            municipality = stationResponse?.municipio ?: "",
            dieselPrice = stationResponse?.precioBiodiesel ?: "",
            gasoline95Price = stationResponse?.precioGasolina95E5 ?: "",
            label = stationResponse?.rotulo ?: ""
        )
    } ?: emptyList()
)