package top.jotyy.coroutinesretrofitexample.ui.article

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.handle
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.repository.ArticleRepository

class ArticleViewModel @ViewModelInject constructor(
    private val articleRepository: ArticleRepository
) : BaseViewModel<List<ArticleEntity>>() {

    init {
        loadData()
    }

    override fun loadData() {
        viewModelScope.launch {
            try {
                articleRepository.fetchArticles().collect {
                    it.handle(
                        ::handleState,
                        ::handleFailure,
                        ::handleSuccess
                    )
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
