package top.jotyy.coroutinesretrofitexample.ui.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.data.error.AuthenticationError
import top.jotyy.coroutinesretrofitexample.databinding.FragmentArticleBinding
import top.jotyy.coroutinesretrofitexample.utils.openDetail
import top.jotyy.coroutinesretrofitexample.utils.openLogin

@AndroidEntryPoint
class ArticleFragment : BaseFragment<FragmentArticleBinding>() {

    private val viewModel by viewModels<ArticleViewModel>()
    private val adapter: ArticleListAdapter by lazy { ArticleListAdapter(R.layout.item_article) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        adapter.setOnItemClickListener { item, _ ->
            //findNavController().navigate(R.id.action_articleFragment_to_motionFragment)
            openDetail(item)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_article

    override fun observeData() {
        viewModel.errorData.observe(this, Observer {
            if (it is AuthenticationError) {
                openLogin()
            } else {
                showSnackbarWithAction(it) { viewModel.retry() }
            }
        })

        viewModel.successData.observe(this, Observer {
            adapter.setAll(it)
        })
    }

}
