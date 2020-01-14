package top.jotyy.coroutines_retrofit_example.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import top.jotyy.coroutines_retrofit_example.MainActivity
import top.jotyy.coroutines_retrofit_example.data.model.User
import top.jotyy.coroutines_retrofit_example.repository.UserRepository
import top.jotyy.coroutines_retrofit_example.repository.UserRepositoryImpl
import top.jotyy.coroutines_retrofit_example.ui.login.di.LoginModule

@Module(includes = [CoreModule::class, RepositoryModule::class])
abstract class AppModule {

    @ContributesAndroidInjector(
        modules = [
            LoginModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}