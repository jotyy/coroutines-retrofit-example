package top.jotyy.coroutinesretrofitexample.ui.detail.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import top.jotyy.coroutinesretrofitexample.di.viewmodel.ViewModelKey
import top.jotyy.coroutinesretrofitexample.ui.detail.ArticleDetailFragment
import top.jotyy.coroutinesretrofitexample.ui.detail.ArticleDetailViewModel

@Module
abstract class ArticleDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailViewModel::class)
    abstract fun articleDetailViewModel(articleDetailViewModel: ArticleDetailViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun articleDetailFragment(): ArticleDetailFragment
}