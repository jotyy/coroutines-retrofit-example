package top.jotyy.coroutines_retrofit_example.repository

import top.jotyy.coroutines_retrofit_example.data.model.User
import top.jotyy.coroutines_retrofit_example.data.source.UserLocalDataSource
import top.jotyy.coroutines_retrofit_example.data.source.UserRemoteDataSource
import top.jotyy.coroutines_retrofit_example.di.AppScope
import javax.inject.Inject
import javax.inject.Singleton


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