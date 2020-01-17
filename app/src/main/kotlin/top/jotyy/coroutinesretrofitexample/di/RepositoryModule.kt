package top.jotyy.coroutinesretrofitexample.di

import dagger.Binds
import dagger.Module
import top.jotyy.coroutinesretrofitexample.repository.UserRepository
import top.jotyy.coroutinesretrofitexample.repository.UserRepositoryImpl

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository
}
