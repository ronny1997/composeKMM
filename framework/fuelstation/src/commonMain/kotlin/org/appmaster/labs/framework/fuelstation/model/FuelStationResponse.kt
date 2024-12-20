package org.appmaster.labs.framework.fuelstation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FuelStationResponse(
    @SerialName("Fecha")
    val fecha: String?,
    @SerialName("ListaEESSPrecio")
    val listaEESSPrecio: List<ListaEESSPrecio?>?,
    @SerialName("Nota")
    val nota: String?,
    @SerialName("ResultadoConsulta")
    val resultadoConsulta: String?
)