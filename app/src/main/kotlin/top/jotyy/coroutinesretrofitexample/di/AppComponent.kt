package top.jotyy.coroutinesretrofitexample.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import top.jotyy.coroutinesretrofitexample.App

@AppScope
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class]
)
interface AppComponent : AndroidInjector<App>{

    fun getAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}
