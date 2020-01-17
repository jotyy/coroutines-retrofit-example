package top.jotyy.coroutinesretrofitexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import top.jotyy.coroutinesretrofitexample.MainActivity
import top.jotyy.coroutinesretrofitexample.ui.login.di.LoginModule

@Module(includes = [CoreModule::class, RepositoryModule::class])
abstract class AppModule {

    @ContributesAndroidInjector(
        modules = [
            LoginModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}
