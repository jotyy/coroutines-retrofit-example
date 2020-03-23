package top.jotyy.coroutinesretrofitexample.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import top.jotyy.coroutinesretrofitexample.R
import top.jotyy.coroutinesretrofitexample.base.BaseFragment
import top.jotyy.coroutinesretrofitexample.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun observeData() {
        viewModel.errorData.observe(this, Observer {
            showSnackbarWithAction(it) { viewModel.retry() }
        })

        viewModel.successData.observe(this, Observer {
            Toast.makeText(context, "登录成功，${it.userName}", Toast.LENGTH_SHORT).show()
        })
    }
}
