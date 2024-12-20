package org.master.labs.core.data

import org.master.labs.core.domain.NetWorkException
import org.master.labs.core.domain.UnknownError

abstract class BaseRepository {
    suspend fun <T> safeExecution(execution: suspend () -> T): T {
        return runCatching {
            execution.invoke()
        }.onFailure { ex ->
            when (ex) {
                is BadRequestException,
                is NotFoundException,
                is InternalServerErrorException,
                is UnknownApiException,
                is UnknownException,
                    -> throw NetWorkException(ex.message)

                else -> {
                    throw UnknownError(ex.message)
                }
            }
        }.getOrElse {
            throw UnknownError("Error inesperado al ejecutar la llamada")
        }
    }
}