package top.jotyy.coroutinesretrofitexample.data.source

import android.net.NetworkInfo
import top.jotyy.coroutinesretrofitexample.data.Failure
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.Success
import top.jotyy.coroutinesretrofitexample.data.error.*
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.model.User
import top.jotyy.coroutinesretrofitexample.data.network.ApiImpl
import java.io.IOException
import javax.inject.Inject
import javax.inject.Provider

class UserRemoteDataSource @Inject constructor(
    private val apiImpl: ApiImpl,
    private val networkInfo: Provider<NetworkInfo>
) {

    private val isNetworkConnected: Boolean
        get() {
            val networkInfo = networkInfo.get()
            return networkInfo != null && networkInfo.isConnected
        }


    suspend fun login(username: String, password: String): Result<User> =
        safeExecute({
            apiImpl.login(username, password)
        }) { it }

    suspend fun register(username: String, nickname: String, password: String): Result<User> =
        safeExecute({
            apiImpl.register(username, nickname, password)
        }) { it }


    private suspend fun <T, R> safeExecute(
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
        if (code == 0) {
            if (data != null) {
                Success(transform(data))
            } else {
                Failure(EmptyResultError())
            }
        } else {
            Failure(NetworkError(msg))
        }
}
