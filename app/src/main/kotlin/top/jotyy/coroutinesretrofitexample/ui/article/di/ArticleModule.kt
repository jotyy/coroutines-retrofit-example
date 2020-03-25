package top.jotyy.coroutinesretrofitexample.ui.article.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import top.jotyy.coroutinesretrofitexample.di.viewmodel.ViewModelKey
import top.jotyy.coroutinesretrofitexample.ui.article.ArticleFragment
import top.jotyy.coroutinesretrofitexample.ui.article.ArticleViewModel

@Module
abstract class ArticleModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun articleViewModel(articleViewModel: ArticleViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun articleFragment(): ArticleFragment
}