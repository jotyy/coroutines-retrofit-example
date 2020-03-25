package top.jotyy.coroutinesretrofitexample.data.source

import android.net.NetworkCapabilities
import top.jotyy.coroutinesretrofitexample.base.BaseRemoteDataSource
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.data.network.ApiImpl
import javax.inject.Inject
import javax.inject.Provider

class ArticleRemoteDataSource @Inject constructor(
    private val apiImpl: ApiImpl,
    networkCapabilities: Provider<NetworkCapabilities>
) : BaseRemoteDataSource(networkCapabilities) {

    suspend fun fetchArticles(): Result<List<ArticleEntity>> =
        safeExecute({apiImpl.fetchArticles()}) { it }

}