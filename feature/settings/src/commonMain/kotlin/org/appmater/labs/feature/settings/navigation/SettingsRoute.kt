package org.appmater.labs.feature.settings.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsRoute {
    @Serializable
    object SettingsScreen : SettingsRoute()
}