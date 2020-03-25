package top.jotyy.coroutinesretrofitexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import top.jotyy.coroutinesretrofitexample.MainActivity
import top.jotyy.coroutinesretrofitexample.ui.article.di.ArticleModule
import top.jotyy.coroutinesretrofitexample.ui.login.di.LoginModule
import top.jotyy.coroutinesretrofitexample.ui.register.di.RegisterModule

@Module(includes = [CoreModule::class, RepositoryModule::class])
abstract class AppModule {

    @ContributesAndroidInjector(
        modules = [
            LoginModule::class,
            RegisterModule::class,
            ArticleModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}
