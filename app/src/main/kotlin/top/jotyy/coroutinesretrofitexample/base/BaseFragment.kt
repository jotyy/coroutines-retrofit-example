package top.jotyy.coroutinesretrofitexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerFragment
import top.jotyy.coroutinesretrofitexample.di.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<T: ViewDataBinding> : DaggerFragment() {

    @get:Inject
    internal var androidInjector: DispatchingAndroidInjector<Any>? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var binding: T

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun observeData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }
}
