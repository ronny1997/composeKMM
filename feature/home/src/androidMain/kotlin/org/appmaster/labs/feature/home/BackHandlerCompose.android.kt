package org.appmaster.labs.feature.home

import androidx.activity.compose.BackHandler
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class AndroidBackHandler : BackHandlerCompose {
    override var onBackPress: (() -> Unit)? = null
    override fun unregister() {
        this.onBackPress = null
    }
    @Composable
   override fun HandleBackPress() {
        BackHandler {
            onBackPress?.let { it() }
        }
        Button(onClick = {
            onBackPress?.let { it() }
        }){
            Text("Back")
        }
    }
}

actual fun getBackHandler():  BackHandlerCompose = AndroidBackHandler()