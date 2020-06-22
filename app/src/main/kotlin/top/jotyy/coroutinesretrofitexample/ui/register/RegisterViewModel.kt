package top.jotyy.coroutinesretrofitexample.ui.register

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import top.jotyy.coroutinesretrofitexample.base.BaseViewModel
import top.jotyy.coroutinesretrofitexample.data.handle
import top.jotyy.coroutinesretrofitexample.data.model.UserEntity
import top.jotyy.coroutinesretrofitexample.repository.UserRepository
import javax.inject.Inject

class RegisterViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel<UserEntity>() {

    val username = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    override fun loadData() {

    }

    fun register() {
        viewModelScope.launch {
            try {
                val result = userRepository.register(
                    username.value!!,
                    password.value!!,
                    nickname.value!!
                )

                result.handle(
                    ::handleState,
                    ::handleFailure,
                    ::handleSuccess
                )
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
