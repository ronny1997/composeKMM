package org.appmaster.labs.feature.home.filter

import androidx.compose.runtime.Composable

@Composable
fun FilterDestination(onNavigation: ()-> Unit = {}, onBack: () -> Unit = {}) {
    FilterScreen(onNavigation, onBack)
}