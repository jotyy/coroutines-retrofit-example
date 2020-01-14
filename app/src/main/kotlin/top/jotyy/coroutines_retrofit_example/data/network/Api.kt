package top.jotyy.coroutines_retrofit_example.data.network

import retrofit2.Response
import retrofit2.http.*
import top.jotyy.coroutines_retrofit_example.data.model.User

internal interface Api {
    @POST("crud/login")
    @FormUrlEncoded
    suspend fun login(@Field("user_name") userName: String, @Field("password") password: String): Response<User>

    @POST("crud/register")
    suspend fun register(userName: String, password: String, nickName: String): Response<User>
}