package top.jotyy.coroutinesretrofitexample.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel by viewModels<RegisterViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_register

    override fun observeData() {
        viewModel.errorData.observe(this, Observer {
            showSnackbarWithAction(it) { viewModel.retry() }
        })

        viewModel.successData.observe(this, Observer {
            showSnackbarWithoutAction("注册成功 ${it.nickName}")
        })
    }

}