package org.appmaster.labs.feature.home.filter

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import org.appmaster.labs.feature.home.getBackHandler

@Composable
fun FilterScreen(
    onNavigation: () -> Unit = {},
    onBack: () -> Unit,
) {
    var isRotated by remember { mutableStateOf(false) }

    val backHandler by remember { mutableStateOf(getBackHandler()) }

    DisposableEffect(true) {
        backHandler.onBackPress = {
            isRotated = !isRotated
        }
        onDispose {
            backHandler.unregister()
        }
    }

    val rotation = remember { Animatable(-90f) }

    LaunchedEffect(isRotated) {
        if (isRotated) {
            val result = rotation.animateTo(
                targetValue = -90f,
                animationSpec = tween(500)
            )

            if (result.endReason == AnimationEndReason.Finished) {
                onBack()
            }
        } else {
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(500)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 8 * density
            },
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        backHandler.HandleBackPress()
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Text("Filter Screen")
        Button(onClick = {
            onNavigation()
        }) {
            Text("To Settings")
        }
    }
}