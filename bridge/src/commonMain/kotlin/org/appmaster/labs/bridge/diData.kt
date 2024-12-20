package org.appmaster.labs.bridge

import org.appmaster.labs.data.fuelstation.repository.allFuelStation.AllFuelStationRepositoryImpl
import org.appmaster.labs.data.fuelstation.repository.filterFuelStationCcAa.FilterFuelStationCcAaRepositoryImpl
import org.appmaster.labs.domain.fuelstation.datasource.allFuelStation.AllFuelStationRepository
import org.appmaster.labs.domain.fuelstation.datasource.filterFuelStationCcAa.FilterFuelStationCcAaRepository
import org.koin.dsl.module

val dataFuelStationModule = module {
    single<AllFuelStationRepository> { AllFuelStationRepositoryImpl(get()) }
    single<FilterFuelStationCcAaRepository> { FilterFuelStationCcAaRepositoryImpl(get()) }
}