package top.jotyy.coroutines_retrofit_example.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProvider: Provider<ViewModel> = viewModelMap[modelClass] ?: throw IllegalArgumentException("Unknown ViewModel")

        return try {
            viewModelProvider.get() as T
                ?: throw IllegalArgumentException("Provider's contained value is null")
        } catch (e: Exception) {
            throw e
        }
    }
}