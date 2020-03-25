package top.jotyy.coroutinesretrofitexample.data.network

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.data.persistent.Preferences
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal const val TIMEOUT_DURATION = 10L

class ApiImpl @Inject constructor(
    private val preferences: Preferences
) : Api {
    private val service by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .addInterceptor(Interceptor.invoke { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer ${preferences.getToken()}")
                            .build()
                        chain.proceed(request)
                    })
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://jotyy.top/")
            .build()
            .create(Api::class.java)
    }

    override suspend fun login(userName: String, password: String): MyResponse<UserEntity> =
        service.login(userName, password)

    override suspend fun register(
        userName: String,
        password: String,
        nickName: String
    ): MyResponse<UserEntity> =
        service.register(userName, password, nickName)

    override suspend fun fetchArticles(): MyResponse<List<ArticleEntity>> =
        service.fetchArticles()
}
