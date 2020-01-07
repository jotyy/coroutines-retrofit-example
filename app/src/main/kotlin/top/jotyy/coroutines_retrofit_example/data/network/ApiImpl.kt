package top.jotyy.coroutines_retrofit_example.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import top.jotyy.coroutines_retrofit_example.data.model.LoggedInUser
import java.util.concurrent.TimeUnit

internal const val TIMEOUT_DURATION = 10L

internal class ApiImpl : Api {
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
            .baseUrl("https://my-json-server.typicode.com/")
            .build()
            .create(Api::class.java)
    }

    override suspend fun login(userName: String, password: String): Response<LoggedInUser> =
        service.login(userName, password)

    override suspend fun register(userName: String, password: String, nickName: String): Response<LoggedInUser> =
        service.register(userName, password, nickName)

}