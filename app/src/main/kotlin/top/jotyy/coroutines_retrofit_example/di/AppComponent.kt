package top.jotyy.coroutines_retrofit_example.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import top.jotyy.coroutines_retrofit_example.App

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