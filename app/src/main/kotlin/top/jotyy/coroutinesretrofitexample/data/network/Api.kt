package top.jotyy.coroutinesretrofitexample.data.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity

internal interface Api {
    @POST("crud/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): MyResponse<UserEntity>

    @POST("crud/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("user_name") userName: String,
        @Field("password") password: String,
        @Field("nick_name") nickName: String
    ): MyResponse<UserEntity>


    @GET("crud/api/v1/articles")
    suspend fun fetchArticles(): MyResponse<List<ArticleEntity>>
}
