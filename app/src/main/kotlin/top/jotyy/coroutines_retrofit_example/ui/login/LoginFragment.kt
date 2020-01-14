package top.jotyy.coroutines_retrofit_example.ui.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import top.jotyy.coroutines_retrofit_example.R
import top.jotyy.coroutines_retrofit_example.base.BaseFragment
import top.jotyy.coroutines_retrofit_example.databinding.FragmentLoginBinding

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

    }
}