package top.jotyy.coroutinesretrofitexample.ui.article

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.handle
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.repository.ArticleRepository
import javax.inject.Inject

class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : BaseViewModel<List<ArticleEntity>>() {

    init {
        loadData()
    }

    override fun loadData() {
        viewModelScope.launch {
            try {
                Timber.i(articleRepository.toString())
                val result = articleRepository.fetchArticles()

                result.handle(
                    ::handleFailure,
                    ::handleSuccess
                )
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}