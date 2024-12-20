package org.master.labs.core.data

class BadRequestException(message: String) : Exception(message)
class NotFoundException(message: String) : Exception(message)
class InternalServerErrorException(message: String) : Exception(message)
class UnknownApiException(message: String) : Exception(message)
class UnknownException(message: String) : Exception(message)