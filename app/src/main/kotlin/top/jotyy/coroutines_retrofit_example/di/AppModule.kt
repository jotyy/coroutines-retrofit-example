package top.jotyy.coroutines_retrofit_example.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import top.jotyy.coroutines_retrofit_example.MainActivity
import top.jotyy.coroutines_retrofit_example.ui.login.di.LoginModule

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}