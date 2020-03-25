package top.jotyy.coroutinesretrofitexample.data.source

import android.net.NetworkCapabilities
import top.jotyy.coroutinesretrofitexample.base.BaseRemoteDataSource
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.data.network.ApiImpl
import javax.inject.Inject
import javax.inject.Provider

class UserRemoteDataSource @Inject constructor(
    private val apiImpl: ApiImpl,
    networkCapabilities: Provider<NetworkCapabilities>
) : BaseRemoteDataSource(networkCapabilities) {

    suspend fun login(username: String, password: String): Result<UserEntity> =
        safeExecute({
            apiImpl.login(username, password)
        }) { it }

    suspend fun register(username: String, nickname: String, password: String): Result<UserEntity> =
        safeExecute({
            apiImpl.register(username, nickname, password)
        }) { it }

}
