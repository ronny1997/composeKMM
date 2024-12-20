package org.appmaster.labs.framework.fuelstation.datasource.cloud.allFuelStation.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.appmaster.labs.framework.fuelstation.datasource.cloud.common.model.FuelStationResponse

class AllFuelStationApi(
    private val client: HttpClient,
) {
    suspend fun getAllFuelStation(): FuelStationResponse {
        return client.get("/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
            .body()
    }
}