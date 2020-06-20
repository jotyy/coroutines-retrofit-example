package top.jotyy.coroutinesretrofitexample.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.repository.ArticleRepository
import javax.inject.Inject

class ArticleDetailViewModel @ViewModelInject constructor(
    private val articleRepository: ArticleRepository
) : BaseViewModel<ArticleEntity>() {

    val article = MutableLiveData<String>()

    override fun loadData() {

    }
}
