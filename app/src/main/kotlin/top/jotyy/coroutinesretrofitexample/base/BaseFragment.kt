package top.jotyy.coroutinesretrofitexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerFragment
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.data.error.Reason
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

    protected fun showSnackbarWithAction(reason: Reason, block: () -> Unit) {
        Snackbar.make(
            binding.root,
            reason.message,
            Snackbar.LENGTH_INDEFINITE
        ).setAction(R.string.retry) {
            block()
        }.show()
    }

    protected fun showSnackbarWithoutAction(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
