package org.appmater.labs.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.appmater.labs.feature.settings.SettingsScreen

fun NavGraphBuilder.settingsGraph(navController: NavHostController) {
    composable<SettingsRoute.SettingsScreen> {
        SettingsScreen()
    }
}