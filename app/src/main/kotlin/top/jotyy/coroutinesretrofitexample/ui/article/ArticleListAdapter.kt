package top.jotyy.coroutinesretrofitexample.ui.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity
import top.jotyy.coroutinesretrofitexample.databinding.ItemArticleBinding

class ArticleListAdapter(
    private val layout: Int
) : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    private var items: List<ArticleEntity> = ArrayList()
    private var itemClickListener: ((item: ArticleEntity, binding: ItemArticleBinding) -> Unit)? =
        null

    inner class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: ArticleEntity) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                itemClickListener?.invoke(article, binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setAll(items: List<ArticleEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(click: (item: ArticleEntity, binding: ItemArticleBinding) -> Unit) {
        itemClickListener = click
    }
}