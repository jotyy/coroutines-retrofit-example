package top.jotyy.coroutinesretrofitexample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory()
            .create(this)

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}