package org.appmaster.labs.bridge

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.appmaster.labs.data.fuelstation.datasource.allFuelStation.AllFuelStationDataSource
import org.appmaster.labs.data.fuelstation.datasource.filterFuelStationCcAa.FilterFuelStationCcAaDataSource
import org.appmaster.labs.framework.fuelstation.datasource.cloud.allFuelStation.AllFuelStationDataSourceImpl
import org.appmaster.labs.framework.fuelstation.datasource.cloud.allFuelStation.api.AllFuelStationApi
import org.appmaster.labs.framework.fuelstation.datasource.cloud.filterFuelStationCcAa.FilterFuelStationCcAaDataSourceImpl
import org.appmaster.labs.framework.fuelstation.datasource.cloud.filterFuelStationCcAa.api.FilterFuelStationCcAaApi
import org.koin.dsl.module

val frameworkFuelStationModule = module {
    single { AllFuelStationApi(get()) }
    single { FilterFuelStationCcAaApi(get()) }
    single<AllFuelStationDataSource> { AllFuelStationDataSourceImpl(get()) }
    single<FilterFuelStationCcAaDataSource> { FilterFuelStationCcAaDataSourceImpl(get()) }
}

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "sedeaplicaciones.minetur.gob.es"
                }
            }
        }
    }
}

