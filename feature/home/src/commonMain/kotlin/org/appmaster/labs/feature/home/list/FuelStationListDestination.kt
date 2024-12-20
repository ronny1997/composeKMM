package org.appmaster.labs.feature.home.list

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.runtime.Composable
import org.appmaster.labs.feature.home.navigation.HomeRoutes
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FuelStationListDestination(
    onNavigation: (HomeRoutes) -> Unit = {},
) {
    val vm: FuelStationListViewModel = koinViewModel()
    FuelStationListScreen(
        state = vm.viewState,
        effectFlow = vm.effect,
        onEventSend = { vm.setEvent(it) },
        onNavigationRequested = {
            when (it) {
                is FuelStationListContract.Effect.Navigation.ToDetail -> {
                    onNavigation(HomeRoutes.DetailScreen(it.id))
                }

                is FuelStationListContract.Effect.Navigation.ToFilter -> {
                    onNavigation(HomeRoutes.FilterScreen)
                }
            }
        },
    )
}