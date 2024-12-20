package org.master.labs.core.domain


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.master.labs.core.ui.DomainExceptions

@Suppress("UNCHECKED_CAST")
abstract class AsyncUseCase<out T : Any, in Params> {
    protected abstract suspend fun runInBackground(params: Params): T

    suspend operator fun invoke(params: Params? = null): Result<T> {
        return withContext(Dispatchers.IO) {
            runCatching {
                runInBackground(params ?: Unit as Params)
            }.recoverCatching { exception ->
                throw handleError(exception)
            }
        }
    }

    protected open fun handleError(e: Throwable): DomainExceptions {
        return when (e) {
            is NetWorkException -> DomainExceptions.NetWorkException(e.message)
            else -> DomainExceptions.UnknownError(e.message)
        }
    }
}