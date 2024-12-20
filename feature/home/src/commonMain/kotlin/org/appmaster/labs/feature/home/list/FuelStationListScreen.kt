package org.appmaster.labs.feature.home.list

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.appmaster.labs.domain.fuelstation.usecase.common.model.Station
import org.appmaster.labs.feature.home.list.components.ShimmerListItem
import org.master.labs.core.ui.SIDE_EFFECTS_KEY

@Composable
fun FuelStationListScreen(
    state: FuelStationListContract.State,
    effectFlow: Flow<FuelStationListContract.Effect>?,
    onEventSend: (FuelStationListContract.Event) -> Unit,
    onNavigationRequested: (FuelStationListContract.Effect.Navigation) -> Unit,
) {
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is FuelStationListContract.Effect.Navigation.ToDetail -> {
                    onNavigationRequested(effect)
                }

                is FuelStationListContract.Effect.Navigation.ToFilter -> {
                    onNavigationRequested(effect)
                }
            }
        }?.collect()
    }

    var isRotated by remember { mutableStateOf(false) }
    var number by rememberSaveable { mutableStateOf(0f) }
    val rotation = remember { Animatable(number) }
    LaunchedEffect(isRotated) {
        if (isRotated) {
            val result = rotation.animateTo(
                targetValue = 90f,
                animationSpec = tween(500)
            )
            if (result.endReason == AnimationEndReason.Finished) {
                number = rotation.value
                onEventSend(FuelStationListContract.Event.NavigateToFilter)
            }
        } else {
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(500)
            )
        }
    }

    Column(
        modifier = Modifier.graphicsLayer {
            rotationY = rotation.value
            cameraDistance = 10 * density
        }
    ) {
        Text("Fuel Station List Screen")

        Row {
            Button(onClick = {
                onEventSend(FuelStationListContract.Event.NavigateToDetail("10"))
            }) {
                Text("NavigateToDetail")
            }
            Button(onClick = {
                isRotated = !isRotated
            }) {
                Text("NavigateToFilter")
            }
        }

        if (state.errorMessage != null) {
            Text(state.errorMessage)
        }

        LazyColumn {
            items(if (state.stationList.isEmpty()) 10 else state.stationList.size) { gasStation ->
                ShimmerListItem(
                    isLoading = state.loading,
                    contentAfterLoading = {
                        GasStationItem(gasStation = state.stationList.getOrNull(gasStation))
                    }
                )
            }
        }

    }
}

@Composable
fun GasStationItem(gasStation: Station?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = gasStation?.label ?: "", style = MaterialTheme.typography.h6)
            Text(
                text = "${gasStation?.address ?: ""}, ${gasStation?.locality ?: ""}",
                style = MaterialTheme.typography.body1
            )
            Text(text = "Horario: ${gasStation?.schedule}", style = MaterialTheme.typography.body2)
            Text(
                text = "Gasóleo A: ${gasStation?.dieselPrice} €/L",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Gasolina 95: ${gasStation?.gasoline95Price} €/L",
                style = MaterialTheme.typography.body2
            )
        }
    }
}