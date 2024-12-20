package org.appmaster.labs.framework.fuelstation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListaEESSPrecio(
    @SerialName("% BioEtanol")
    val bioEtanol: String?,
    @SerialName("C.P.")
    val cP: String?,
    @SerialName("Dirección")
    val dirección: String?,
    @SerialName("Horario")
    val horario: String?,
    @SerialName("IDCCAA")
    val iDCCAA: String?,
    @SerialName("IDEESS")
    val iDEESS: String?,
    @SerialName("IDMunicipio")
    val iDMunicipio: String?,
    @SerialName("IDProvincia")
    val iDProvincia: String?,
    @SerialName("Latitud")
    val latitud: String?,
    @SerialName("Localidad")
    val localidad: String?,
    @SerialName("Longitud (WGS84)")
    val longitudWGS84: String?,
    @SerialName("Margen")
    val margen: String?,
    @SerialName("Municipio")
    val municipio: String?,
    @SerialName("Precio Biodiesel")
    val precioBiodiesel: String?,
    @SerialName("Precio Bioetanol")
    val precioBioetanol: String?,
    @SerialName("Precio Gas Natural Comprimido")
    val precioGasNaturalComprimido: String?,
    @SerialName("Precio Gas Natural Licuado")
    val precioGasNaturalLicuado: String?,
    @SerialName("Precio Gases licuados del petróleo")
    val precioGasesLicuadosDelPetróleo: String?,
    @SerialName("Precio Gasoleo A")
    val precioGasoleoA: String?,
    @SerialName("Precio Gasoleo B")
    val precioGasoleoB: String?,
    @SerialName("Precio Gasoleo Premium")
    val precioGasoleoPremium: String?,
    @SerialName("Precio Gasolina 95 E10")
    val precioGasolina95E10: String?,
    @SerialName("Precio Gasolina 95 E5")
    val precioGasolina95E5: String?,
    @SerialName("Precio Gasolina 95 E5 Premium")
    val precioGasolina95E5Premium: String?,
    @SerialName("Precio Gasolina 98 E10")
    val precioGasolina98E10: String?,
    @SerialName("Precio Gasolina 98 E5")
    val precioGasolina98E5: String?,
    @SerialName("Precio Hidrogeno")
    val precioHidrogeno: String?,
    @SerialName("Provincia")
    val provincia: String?,
    @SerialName("Remisión")
    val remisión: String?,
    @SerialName("Rótulo")
    val rótulo: String?,
    @SerialName("Tipo Venta")
    val tipoVenta: String?,
    @SerialName("% Éster metílico")
    val ésterMetílico: String?,
)