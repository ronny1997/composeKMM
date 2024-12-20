package org.appmaster.labs.feature.home.di

import org.koin.core.module.dsl.viewModelOf
import org.appmaster.labs.feature.home.AppViewModel
import org.appmaster.labs.feature.home.list.FuelStationListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::FuelStationListViewModel)
}