package top.jotyy.coroutinesretrofitexample.data.error


/**
 * [Result.Failure] reasons
 */
sealed class Reason(val message: String)

class NetworkError(message: String? = "Network error") : Reason(message ?: "Network error")
class EmptyResultError : Reason("Empty result")
class GenericError : Reason("Something went error")
class ResponseError : Reason("Woops, there perhaps got a server error")
class TimeoutError : Reason("Request timeout")
class PersistenceEmpty : Reason("Persistence is empty")
class NoNetworkPersistenceEmpty : Reason("")