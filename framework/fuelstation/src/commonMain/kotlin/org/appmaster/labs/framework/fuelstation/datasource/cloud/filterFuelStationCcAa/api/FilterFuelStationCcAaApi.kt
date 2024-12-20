package org.appmaster.labs.framework.fuelstation.datasource.cloud.filterFuelStationCcAa.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.appmaster.labs.framework.fuelstation.datasource.cloud.common.model.FuelStationResponse

class FilterFuelStationCcAaApi(
    private val client: HttpClient,
) {
    suspend fun filterFuelStationCcAa(ccAa: String): FuelStationResponse {
        return client.get("/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroCCAA/$ccAa")
            .body()
    }
}