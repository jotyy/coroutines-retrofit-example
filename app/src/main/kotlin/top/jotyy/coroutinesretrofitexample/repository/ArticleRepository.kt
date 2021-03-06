package top.jotyy.coroutinesretrofitexample.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import top.jotyy.coroutinesretrofitexample.base.BaseRepository
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.data.source.ArticleRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

abstract class ArticleRepository : BaseRepository() {

    abstract suspend fun fetchArticles(): Flow<Result<List<ArticleEntity>>>
}

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository() {

    override suspend fun fetchArticles(): Flow<Result<List<ArticleEntity>>> =
        execute {
            remoteDataSource.fetchArticles()
        }
}
