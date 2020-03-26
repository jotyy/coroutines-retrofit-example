package top.jotyy.coroutinesretrofitexample.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.data.model.ArticleEntity

fun Fragment.openArticle() =
    NavHostFragment.findNavController(this)
        .navigate(R.id.articleFragment)

fun Fragment.openLogin() =
    NavHostFragment.findNavController(this)
        .navigate(R.id.action_articleFragment_to_loginFragment)

fun Fragment.openRegister() =
    NavHostFragment.findNavController(this)
        .navigate(R.id.action_loginFragment_to_registerFragment)


fun Fragment.openDetail(article: ArticleEntity) {
    val bundle = Bundle()
    bundle.putSerializable("article", article)
    NavHostFragment.findNavController(this)
        .navigate(R.id.action_articleFragment_to_articleDetailFragment, bundle)
}
