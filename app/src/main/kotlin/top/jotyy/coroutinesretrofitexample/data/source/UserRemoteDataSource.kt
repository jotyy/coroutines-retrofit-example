package top.jotyy.coroutinesretrofitexample.data.source

import android.net.NetworkInfo
import top.jotyy.coroutinesretrofitexample.data.error.ServerException
import top.jotyy.coroutinesretrofitexample.data.model.User
import top.jotyy.coroutinesretrofitexample.data.network.ApiImpl
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


    suspend fun login(username: String, password: String): User {
        if (isNetworkConnected) {
            val response = apiImpl.login(username, password)
            if (response.isSuccessful) {
                return response.body() ?: throw ServerException()
            } else {
                throw ServerException()
            }
        } else {
            throw ServerException()
        }
    }

    suspend fun register(username: String, nickname: String, password: String): User {
        if (isNetworkConnected) {
            val response = apiImpl.login(username, password)
            if (response.isSuccessful) {
                return response.body() ?: throw ServerException()
            } else {
                throw ServerException()
            }
        } else {
            throw ServerException()
        }
    }
}
