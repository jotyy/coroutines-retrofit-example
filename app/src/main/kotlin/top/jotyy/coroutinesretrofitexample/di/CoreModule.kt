package top.jotyy.coroutinesretrofitexample.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import top.jotyy.coroutinesretrofitexample.data.persistent.Preferences
import top.jotyy.coroutinesretrofitexample.data.persistent.PreferencesImpl

@InstallIn(ApplicationComponent::class)
@Module
object CoreModule {

    @Provides
    fun providePreferences(@ApplicationContext appContext: Context): Preferences =
        PreferencesImpl(appContext)

    @Provides
    fun provideNetworkCapabilities(@ApplicationContext appContext: Context): NetworkCapabilities? =
        (appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            this.getNetworkCapabilities(this.activeNetwork)
        }

}
