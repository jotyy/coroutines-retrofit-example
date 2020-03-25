package top.jotyy.coroutinesretrofitexample.ui.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.databinding.FragmentArticleBinding

class ArticleFragment : BaseFragment<FragmentArticleBinding>() {

    private val viewModel by viewModels<ArticleViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_article

    override fun observeData() {
        viewModel.errorData.observe(this, Observer {
            showSnackbarWithAction(it) { viewModel.retry() }
        })

        viewModel.successData.observe(this, Observer {
            showSnackbarWithoutAction("获取文章列表成功")
        })
    }

}