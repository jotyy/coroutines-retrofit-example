package top.jotyy.coroutinesretrofitexample.ui.register.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import top.jotyy.coroutinesretrofitexample.di.viewmodel.ViewModelKey
import top.jotyy.coroutinesretrofitexample.ui.register.RegisterFragment
import top.jotyy.coroutinesretrofitexample.ui.register.RegisterViewModel

@Module
abstract class RegisterModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun registerViewModel(registerViewModel: RegisterViewModel): ViewModel


    @ContributesAndroidInjector
    abstract fun registerFragment(): RegisterFragment
}
