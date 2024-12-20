package org.appmaster.labs.composekmm.di

import org.appmaster.labs.bridge.dataFuelStationModule
import org.appmaster.labs.bridge.domainFuelStationModule
import org.appmaster.labs.bridge.frameworkFuelStationModule
import org.appmaster.labs.bridge.networkModule
import org.appmaster.labs.feature.home.di.viewModelModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {

}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            frameworkFuelStationModule,
            dataFuelStationModule,
            domainFuelStationModule,
            viewModelModule,
            networkModule
        )
    }
}