package top.jotyy.coroutinesretrofitexample.repository

import top.jotyy.coroutinesretrofitexample.data.model.User
import top.jotyy.coroutinesretrofitexample.data.source.UserLocalDataSource
import top.jotyy.coroutinesretrofitexample.data.source.UserRemoteDataSource
import top.jotyy.coroutinesretrofitexample.di.AppScope
import javax.inject.Inject


abstract class UserRepository {
    abstract suspend fun login(username: String, password: String): User
    abstract suspend fun register(
        username: String,
        nickname: String,
        password: String
    ): User
}

@AppScope
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository() {

    override suspend fun login(username: String, password: String): User =
        userRemoteDataSource.login(username, password)

    override suspend fun register(username: String, nickname: String, password: String): User =
        userRemoteDataSource.register(username, nickname, password)
}
