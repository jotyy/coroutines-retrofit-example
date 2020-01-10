package top.jotyy.coroutines_retrofit_example.ui.login.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import top.jotyy.coroutines_retrofit_example.di.viewmodel.ViewModelKey
import top.jotyy.coroutines_retrofit_example.ui.login.LoginFragment
import top.jotyy.coroutines_retrofit_example.ui.login.LoginViewModel

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(loginViewModel: LoginViewModel): ViewModel


    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment
}