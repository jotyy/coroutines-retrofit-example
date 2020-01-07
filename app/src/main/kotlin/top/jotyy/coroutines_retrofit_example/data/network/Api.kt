package top.jotyy.coroutines_retrofit_example.data.network

import retrofit2.Response
import retrofit2.http.POST
import top.jotyy.coroutines_retrofit_example.data.model.LoggedInUser

internal interface Api {
    @POST("api/v1/users/login")
    suspend fun login(userName: String, password: String): Response<LoggedInUser>

    @POST("api/v1/users/register")
    suspend fun register(userName: String, password: String, nickName: String): Response<LoggedInUser>
}