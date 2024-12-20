package org.appmaster.labs.feature.home.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeRoutes {
    @Serializable
    object FuelStationListScreen : HomeRoutes()
    @Serializable
    object FilterScreen : HomeRoutes()
    @Serializable
    data class DetailScreen(val id: String) : HomeRoutes()
}