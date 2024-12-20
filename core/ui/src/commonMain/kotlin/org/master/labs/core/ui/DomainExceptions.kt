package org.master.labs.core.ui

sealed class DomainExceptions: Exception() {
    data class NetWorkException(override val message: String?) : DomainExceptions()
    data class UnknownError(override val message: String?) : DomainExceptions()
}