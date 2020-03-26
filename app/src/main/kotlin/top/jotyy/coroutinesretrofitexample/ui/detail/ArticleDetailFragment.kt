package top.jotyy.coroutinesretrofitexample.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.zzhoujay.markdown.MarkDown
import kotlinx.android.synthetic.main.activity_main.*
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.databinding.FragmentArticleDetailBinding

class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding>() {

    private val viewModel by viewModels<ArticleDetailViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        val article = arguments?.getSerializable("article") as ArticleEntity
        binding.tvArticle.post {
            val spanned = MarkDown.fromMarkdown(
                article.content,
                {
                    val drawable = ContextCompat.getDrawable(context!!, R.mipmap.ic_launcher)
                    drawable?.setBounds(0, 0, 400, 400)
                    drawable
                },
                binding.tvArticle
            )
            binding.tvArticle.text = spanned
        }
        activity?.toolbar?.title = article.title
    }

    override fun getLayoutId(): Int = R.layout.fragment_article_detail

    override fun observeData() {}

}