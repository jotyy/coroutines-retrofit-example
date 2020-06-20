package top.jotyy.coroutinesretrofitexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import top.jotyy.coroutinesretrofitexample.repository.*

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindArticleRepository(repositoryImpl: ArticleRepositoryImpl): ArticleRepository
}
