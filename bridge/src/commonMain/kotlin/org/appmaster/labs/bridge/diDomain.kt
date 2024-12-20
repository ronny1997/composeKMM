package org.appmaster.labs.bridge

import org.appmaster.labs.domain.fuelstation.usecase.allFuelStation.AllFuelStationUseCase
import org.appmaster.labs.domain.fuelstation.usecase.filterFuelStationCcAa.FilterFuelStationCcAaUseCase
import org.koin.dsl.module

val domainFuelStationModule = module {
    single { AllFuelStationUseCase(get()) }
    single { FilterFuelStationCcAaUseCase(get()) }
}