package top.jotyy.coroutinesretrofitexample.base

import android.net.NetworkCapabilities
import top.jotyy.coroutinesretrofitexample.data.Failure
import top.jotyy.coroutinesretrofitexample.data.Success
import top.jotyy.coroutinesretrofitexample.data.error.AuthenticationError
import top.jotyy.coroutinesretrofitexample.data.error.EmptyResultError
import top.jotyy.coroutinesretrofitexample.data.error.NetworkError
import top.jotyy.coroutinesretrofitexample.data.error.TimeoutError
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import java.io.IOException
import javax.inject.Provider

abstract class BaseRemoteDataSource(
    private val networkCapabilities: Provider<NetworkCapabilities>
) {
    private val isNetworkConnected
        get() = networkCapabilities.get()
            .hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)

    protected suspend fun <T, R> safeExecute(
        block: suspend () -> MyResponse<T>,
        transform: (T) -> R
    ) =
        if (isNetworkConnected) {
            try {
                block().extractResponseBody(transform)
            } catch (e: IOException) {
                Failure(TimeoutError())
            }
        } else {
            Failure(NetworkError())
        }

    private inline fun <T, R> MyResponse<T>.extractResponseBody(transform: (T) -> R) =
        when (code) {
            0 -> {
                if (data != null) {
                    Success(transform(data))
                } else {
                    Failure(EmptyResultError())
                }
            }
            40004 -> Failure(AuthenticationError())
            else -> Failure(NetworkError(msg))
        }
}

