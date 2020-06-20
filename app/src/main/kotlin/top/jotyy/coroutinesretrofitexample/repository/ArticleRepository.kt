package top.jotyy.coroutinesretrofitexample.repository

import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.data.source.ArticleRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

abstract class ArticleRepository {

    abstract suspend fun fetchArticles(): Result<List<ArticleEntity>>
}

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository() {

    override suspend fun fetchArticles(): Result<List<ArticleEntity>> =
        remoteDataSource.fetchArticles()
}
