package top.jotyy.coroutinesretrofitexample.data.source

import android.net.NetworkCapabilities
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import top.jotyy.coroutinesretrofitexample.data.Failure
import top.jotyy.coroutinesretrofitexample.data.error.AuthenticationError
import top.jotyy.coroutinesretrofitexample.data.error.NetworkError
import top.jotyy.coroutinesretrofitexample.data.model.MyResponse
import top.jotyy.coroutinesretrofitexample.data.network.ApiImpl
import top.jotyy.coroutinesretrofitexample.data.onFailure
import javax.inject.Provider

@OptIn(ExperimentalCoroutinesApi::class)
class UserRemoteDataSourceTest {

    private val apiImpl = mockk<ApiImpl>(relaxed = true)
    private val networkCapabilities = mockk<Provider<NetworkCapabilities>>(relaxed = true) {
        every { get().hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) } returns mockk(relaxed = true)
    }

    private val source =
        spyk(UserRemoteDataSource(apiImpl = apiImpl, networkCapabilities = networkCapabilities))

    @Nested
    inner class Login {
        val username = "lee"
        val password = "123456"

        @Test
        fun `should return network error when internet is not connected`() {
            every {
                networkCapabilities.get().hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            } returns false

            runBlockingTest {
                val result = source.login(username, password)

                result shouldBeInstanceOf Failure::class
                result.onFailure {
                    it shouldBeInstanceOf NetworkError::class
                }
            }
        }

        @Test
        fun `should return response error when it is not successful`() {
            every {
                networkCapabilities.get().hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            } returns true
            coEvery { apiImpl.login(any(), any()).code } returns 400

            runBlockingTest {
                val result = source.login(username, password)

                result shouldBeInstanceOf Failure::class
                result.onFailure { it shouldBeInstanceOf NetworkError::class }
            }
        }
    }
}
