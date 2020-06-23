package top.jotyy.coroutinesretrofitexample.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.handle
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.repository.UserRepository

class LoginViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel<UserEntity>() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun getLogin() {
        Timber.i("Clicked Login Button： {${username.value}, ${password.value}}")
        viewModelScope.launch {
            try {
                userRepository.login(username.value!!, password.value!!)
                    .collect {
                        it.handle(
                            ::handleState,
                            ::handleFailure,
                            ::handleSuccess
                        )
                    }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun saveToken(token: String) {
        userRepository.setToken(token)
    }
}
