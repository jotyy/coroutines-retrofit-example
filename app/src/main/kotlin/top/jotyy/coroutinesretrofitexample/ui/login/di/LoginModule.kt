package top.jotyy.coroutinesretrofitexample.ui.login.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import top.jotyy.coroutinesretrofitexample.di.viewmodel.ViewModelKey
import top.jotyy.coroutinesretrofitexample.ui.login.LoginFragment
import top.jotyy.coroutinesretrofitexample.ui.login.LoginViewModel

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(loginViewModel: LoginViewModel): ViewModel


    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment
}
