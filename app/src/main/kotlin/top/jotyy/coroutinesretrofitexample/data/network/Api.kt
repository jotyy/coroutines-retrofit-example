package top.jotyy.coroutinesretrofitexample.data.network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.model.User

internal interface Api {
    @POST("crud/login")
    @FormUrlEncoded
    suspend fun login(@Field("user_name") userName: String, @Field("password") password: String): MyResponse<User>

    @POST("crud/register")
    suspend fun register(userName: String, password: String, nickName: String): MyResponse<User>
}
