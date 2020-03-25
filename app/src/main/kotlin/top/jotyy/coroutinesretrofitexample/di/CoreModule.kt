package top.jotyy.coroutinesretrofitexample.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.Module
import dagger.Provides
import top.jotyy.coroutinesretrofitexample.data.persistent.Preferences
import top.jotyy.coroutinesretrofitexample.data.persistent.PreferencesImpl

@Module
class CoreModule {

    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext

    @Provides
    fun providePreferences(app: Application): Preferences = PreferencesImpl(app.applicationContext)

    @Provides
    fun provideNetworkCapabilities(app: Application): NetworkCapabilities? =
        (app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            this.getNetworkCapabilities(this.activeNetwork)
        }

}
