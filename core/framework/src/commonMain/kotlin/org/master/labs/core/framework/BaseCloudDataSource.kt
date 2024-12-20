package org.master.labs.core.framework

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import org.master.labs.core.data.BadRequestException
import org.master.labs.core.data.InternalServerErrorException
import org.master.labs.core.data.NotFoundException
import org.master.labs.core.data.UnknownApiException
import org.master.labs.core.data.UnknownException

abstract class BaseCloudDataSource {
    protected inline fun <reified T> execute(call: () -> T): T {
        return runCatching {
            call()
        }.onFailure { throwable ->
            when (throwable) {
                is ClientRequestException -> {
                    when (throwable.response.status.value) {
                        400 -> throw BadRequestException("Solicitud incorrecta: ${throwable.message}")
                        404 -> throw NotFoundException("Recurso no encontrado: ${throwable.message}")
                        else -> throw UnknownApiException("Error de cliente desconocido: ${throwable.message}")
                    }
                }
                is ServerResponseException -> {
                    when (throwable.response.status.value) {
                        500 -> throw InternalServerErrorException("Error interno del servidor: ${throwable.message}")
                        else -> throw UnknownApiException("Error de servidor desconocido: ${throwable.message}")
                    }
                }
                else -> throw UnknownApiException("Error desconocido: ${throwable.message}")
            }
        }.getOrElse {
            throw UnknownException("Error inesperado al ejecutar la llamada")
        }
    }
}