package org.appmaster.labs.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import composekmm.feature.home.generated.resources.Res
import composekmm.feature.home.generated.resources.compose_multiplatform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.painterResource
import org.master.labs.core.ui.SIDE_EFFECTS_KEY

@Composable
fun AppScreen(
    state: AppContract.State,
    effectFlow: Flow<AppContract.Effect>?,
    onEventSend: (AppContract.Event) -> Unit,
    onNavigationRequested: (AppContract.Effect.Navigation) -> Unit,
) {
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                AppContract.Effect.Navigation.ToDetail -> {

                }
            }
        }?.collect()
    }

    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            showContent = !showContent
            onEventSend(AppContract.Event.GetData)
        }) {
            Text("Click me!")
        }

        AnimatedVisibility(showContent) {
            if (state.loading) {
                Text("Loading")
            }
            if (state.message != null) {
                Text(state.message)
            }

            val greeting = remember { Greeting().greet() }

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}