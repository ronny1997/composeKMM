package org.appmaster.labs.feature.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class IOSBackHandlerCompose: BackHandlerCompose {
    override var onBackPress: (() -> Unit)? = null

    override fun unregister() {
        this.onBackPress = null
    }

    @Composable
    override fun HandleBackPress() {
        Button(onClick = {
            onBackPress?.let { it() }
        }){
            Text("Back")
        }
    }

}
actual fun getBackHandler():  BackHandlerCompose = IOSBackHandlerCompose()