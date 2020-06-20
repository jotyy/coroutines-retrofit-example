package top.jotyy.coroutinesretrofitexample.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.zzhoujay.markdown.MarkDown
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.layout_detail_scrolling_content.*
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.databinding.FragmentArticleDetailBinding

@AndroidEntryPoint
class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding>() {

    private val viewModel: ArticleDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        val article = arguments?.getSerializable("article") as ArticleEntity
        tv_content.post {
            val spanned = MarkDown.fromMarkdown(
                article.content,
                {
                    val drawable = ContextCompat.getDrawable(context!!, R.mipmap.ic_launcher)
                    drawable?.setBounds(0, 0, 400, 400)
                    drawable
                },
                tv_content
            )
            tv_content.text = spanned
        }
        binding.tvTitle.text = article.title
        binding.tvAuthor.text = "Written by ${article.createdBy}"
        binding.tvDate.text = article.createdAt
        Picasso.get().load(article.coverUrl)
            .into(binding.ivCover)
    }

    override fun getLayoutId(): Int = R.layout.fragment_article_detail

    override fun observeData() {}

}
