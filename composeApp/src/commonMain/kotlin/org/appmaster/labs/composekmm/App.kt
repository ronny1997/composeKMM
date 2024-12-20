package org.appmaster.labs.composekmm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import composekmm.composeapp.generated.resources.Res
import composekmm.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import org.appmaster.labs.framework.fuelstation.MyClassFuelStation
import org.appmaster.labs.framework.fuelstation.model.FuelStationResponse
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    val myClassFuelStation: MyClassFuelStation = koinInject()

    var gasoilResponse by remember { mutableStateOf<FuelStationResponse?>(null) }
    val coroutineScope = rememberCoroutineScope()
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                showContent = !showContent
                coroutineScope.launch {
                    try {
                        val response = myClassFuelStation.getData()
                        gasoilResponse = response
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting ${gasoilResponse?.nota}")
                }
            }
        }
    }
}