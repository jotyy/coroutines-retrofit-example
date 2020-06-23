package top.jotyy.coroutinesretrofitexample.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import top.jotyy.coroutinesretrofitexample.base.BaseRepository
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.data.source.UserLocalDataSource
import top.jotyy.coroutinesretrofitexample.data.source.UserRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton


abstract class UserRepository : BaseRepository() {
    abstract suspend fun login(
        username: String,
        password: String
    ): Flow<Result<UserEntity>>

    abstract suspend fun register(
        username: String,
        nickname: String,
        password: String
    ): Flow<Result<UserEntity>>

    abstract fun setToken(token: String)
    abstract fun getToken(): String
}

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository() {

    override suspend fun login(
        username: String,
        password: String
    ): Flow<Result<UserEntity>> =
        execute {
            userRemoteDataSource.login(username, password)
        }

    override suspend fun register(
        username: String,
        nickname: String,
        password: String
    ): Flow<Result<UserEntity>> =
        execute {
            userRemoteDataSource.register(username, nickname, password)
        }

    override fun setToken(token: String) =
        userLocalDataSource.setToken(token)

    override fun getToken(): String =
        userLocalDataSource.getToken()
}

