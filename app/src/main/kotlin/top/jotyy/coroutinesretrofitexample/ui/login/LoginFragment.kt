package top.jotyy.coroutinesretrofitexample.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.databinding.FragmentLoginBinding
import top.jotyy.coroutinesretrofitexample.utils.openArticle
import top.jotyy.coroutinesretrofitexample.utils.openRegister

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        binding.signUp.setOnClickListener {
            openRegister()
        }
    }

    override fun observeData() {
        viewModel.errorData.observe(this, Observer {
            showSnackbarWithAction(it) { viewModel.retry() }
        })

        viewModel.successData.observe(this, Observer {
            viewModel.saveToken(it.token)
            openArticle()
        })
    }
}
