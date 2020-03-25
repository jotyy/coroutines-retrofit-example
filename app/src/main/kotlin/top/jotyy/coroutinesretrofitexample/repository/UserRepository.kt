package top.jotyy.coroutinesretrofitexample.repository

import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.data.source.UserLocalDataSource
import top.jotyy.coroutinesretrofitexample.data.source.UserRemoteDataSource
import top.jotyy.coroutinesretrofitexample.di.AppScope
import javax.inject.Inject


abstract class UserRepository {
    abstract suspend fun login(username: String, password: String): Result<UserEntity>
    abstract suspend fun register(
        username: String,
        nickname: String,
        password: String
    ): Result<UserEntity>

    abstract fun setToken(token: String)
    abstract fun getToken(): String
}

@AppScope
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository() {

    override suspend fun login(username: String, password: String): Result<UserEntity> =
        userRemoteDataSource.login(username, password)

    override suspend fun register(
        username: String,
        nickname: String,
        password: String
    ): Result<UserEntity> =
        userRemoteDataSource.register(username, nickname, password)

    override fun setToken(token: String) =
        userLocalDataSource.setToken(token)

    override fun getToken(): String =
        userLocalDataSource.getToken()
}
