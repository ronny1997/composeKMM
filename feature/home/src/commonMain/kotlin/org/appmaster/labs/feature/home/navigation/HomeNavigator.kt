package org.appmaster.labs.feature.home.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.appmaster.labs.feature.home.detail.DetailDestination
import org.appmaster.labs.feature.home.filter.FilterDestination
import org.appmaster.labs.feature.home.list.FuelStationListDestination

fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
    onNavigationSettings: () -> Unit = {},
) {
    composable<HomeRoutes.FuelStationListScreen>  {
        FuelStationListDestination(
            onNavigation = { navController.navigate(it) },
        )
    }
    composable<HomeRoutes.DetailScreen>  { backStackEntry ->
        val id = backStackEntry.toRoute<HomeRoutes.DetailScreen>().id
        DetailDestination(id)
    }
    composable<HomeRoutes.FilterScreen> {
        FilterDestination(onNavigationSettings, onBack = { navController.popBackStack() })
    }
}