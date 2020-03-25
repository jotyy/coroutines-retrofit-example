package top.jotyy.coroutinesretrofitexample.di

import dagger.Binds
import dagger.Module
import top.jotyy.coroutinesretrofitexample.repository.*

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindArticleRepository(repositoryImpl: ArticleRepositoryImpl): ArticleRepository
}
