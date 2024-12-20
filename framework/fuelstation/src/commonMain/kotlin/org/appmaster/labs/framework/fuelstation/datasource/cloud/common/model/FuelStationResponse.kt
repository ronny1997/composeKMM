package org.appmaster.labs.framework.fuelstation.datasource.cloud.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FuelStationResponse(
    @SerialName("Fecha")
    val fecha: String?,
    @SerialName("ListaEESSPrecio")
    val stationResponseList: List<StationResponse?>?,
    @SerialName("Nota")
    val nota: String?,
    @SerialName("ResultadoConsulta")
    val resultadoConsulta: String?
)