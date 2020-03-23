package top.jotyy.coroutinesretrofitexample.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.handle
import top.jotyy.coroutinesretrofitexample.data.model.User
import top.jotyy.coroutinesretrofitexample.repository.UserRepository
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel<User>() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    override suspend fun loadData() {

    }

    fun getLogin(view: View) {
        Timber.i("Clicked Login Button： {${username.value}, ${password.value}}")
        viewModelScope.launch {
            try {
                val result = userRepository.login(username.value!!, password.value!!)
                result.handle(
                    ::handleFailure,
                    ::handleSuccess
                )
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}