package top.jotyy.coroutinesretrofitexample.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.Module
import dagger.Provides

@Module
class CoreModule {

    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideNetworkInfo(app: Application): NetworkInfo? {
        val connectivityManager =
            app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo
    }
}
