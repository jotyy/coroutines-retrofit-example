package top.jotyy.coroutinesretrofitexample.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.model.User
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal const val TIMEOUT_DURATION = 10L

class ApiImpl @Inject constructor(): Api {
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
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://jotyy.top/")
            .build()
            .create(Api::class.java)
    }

    override suspend fun login(userName: String, password: String): MyResponse<User> =
        service.login(userName, password)

    override suspend fun register(userName: String, password: String, nickName: String): MyResponse<User> =
        service.register(userName, password, nickName)

}
