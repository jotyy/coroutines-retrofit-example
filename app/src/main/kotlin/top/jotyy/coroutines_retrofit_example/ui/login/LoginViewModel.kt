package top.jotyy.coroutines_retrofit_example.ui.login

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import top.jotyy.coroutines_retrofit_example.repository.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun getLogin(view: View) {
        Timber.i("Clicked Login Button： {${username.value}, ${password.value}}")
        viewModelScope.launch{
            try {
                val response = userRepository.login(username.value!!, password.value!!)
            } catch (e: Exception) {
                Toast.makeText(view.context, "${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}