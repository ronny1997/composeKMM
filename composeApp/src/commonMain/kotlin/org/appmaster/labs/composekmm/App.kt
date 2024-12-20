package org.appmaster.labs.composekmm

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.appmaster.labs.feature.home.navigation.HomeRoutes
import org.appmaster.labs.feature.home.navigation.homeGraph
import org.appmater.labs.feature.settings.navigation.SettingsRoute
import org.appmater.labs.feature.settings.navigation.settingsGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = HomeRoutes.FuelStationListScreen){
            homeGraph(navController){
                navController.navigate(SettingsRoute.SettingsScreen)
            }
            settingsGraph(navController)
        }
    }
}

