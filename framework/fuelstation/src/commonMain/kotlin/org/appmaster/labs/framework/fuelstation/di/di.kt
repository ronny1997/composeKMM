package org.appmaster.labs.framework.fuelstation.di

import org.appmaster.labs.framework.fuelstation.MyClassFuelStation
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val fuelStationModule = module {
    factoryOf(::MyClassFuelStation)
}