package org.appmaster.labs.framework.fuelstation

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.appmaster.labs.core.MyClassCore
import org.appmaster.labs.framework.fuelstation.model.FuelStationResponse

class MyClassFuelStation(
    private val client: HttpClient,
) {
    val s = MyClassCore()
    suspend fun getData(): FuelStationResponse {
        return client.get("/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
            .body()
    }

}