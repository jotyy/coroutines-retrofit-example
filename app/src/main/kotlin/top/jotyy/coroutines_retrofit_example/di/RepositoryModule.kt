package top.jotyy.coroutines_retrofit_example.di

import dagger.Binds
import dagger.Module
import top.jotyy.coroutines_retrofit_example.repository.UserRepository
import top.jotyy.coroutines_retrofit_example.repository.UserRepositoryImpl

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository
}