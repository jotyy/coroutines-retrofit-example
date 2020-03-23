package top.jotyy.coroutinesretrofitexample.data

import top.jotyy.coroutinesretrofitexample.data.error.Reason

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T>

// region Subclasses

class Success<out T>(val successData: T) : Result<T>()
class Failure(val errorData: Reason) : Result<Nothing>()

// region Extensions

inline fun <T> Result<T>.handle(failureBlock: (Reason) -> Unit, successBlock: (T) -> Unit) {
    when (this) {
        is Success -> successBlock(successData)
        is Failure -> failureBlock(errorData)
    }
}

inline fun <T> Result<T>.onSuccess(successBlock: (T) -> Unit): Result<T> {
    if (this is Success)
        successBlock(successData)

    return this
}

inline fun <T> Result<T>.onFailure(errorBlock: (Reason) -> Unit): Result<T> {
    if (this is Failure)
        errorBlock(errorData)

    return this
}

