package top.jotyy.coroutinesretrofitexample.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import top.jotyy.coroutinesretrofitexample.data.error.Reason

abstract class BaseViewModel<T> : ViewModel() {

    abstract suspend fun loadData()

    init {
        viewModelScope.launch { loadData() }
    }

    private val _successData = MutableLiveData<T>()
    private val _errorData = MutableLiveData<Reason>()

    val successData: LiveData<T>
        get() = _successData

    val errorData: LiveData<Reason>
        get() = _errorData

    protected fun handleSuccess(data: T) {
        _successData.value = data
    }

    protected fun handleFailure(reason: Reason) {
        _errorData.value = reason
    }

    fun refresh() {
        viewModelScope.launch { loadData() }
    }

    fun retry() {
        viewModelScope.launch { loadData() }
    }
}