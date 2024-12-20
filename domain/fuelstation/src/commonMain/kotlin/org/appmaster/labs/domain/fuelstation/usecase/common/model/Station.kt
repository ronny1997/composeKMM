package org.appmaster.labs.domain.fuelstation.usecase.common.model

data class Station (
    val postalCode: String,
    val address: String,
    val schedule: String,
    val latitude: String,
    val longitude: String,
    val locality: String,
    val province: String,
    val municipality: String,
    val dieselPrice: String,
    val gasoline95Price: String,
    val label: String
)