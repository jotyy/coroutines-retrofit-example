package top.jotyy.coroutinesretrofitexample.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import top.jotyy.coroutinesretrofitexample.data.State
import top.jotyy.coroutinesretrofitexample.data.error.Reason

abstract class BaseViewModel<T> : ViewModel() {

    abstract fun loadData()

    private val _stateData = MutableLiveData<State>()
    private val _successData = MutableLiveData<T>()
    private val _errorData = MutableLiveData<Reason>()

    val stateData: LiveData<State>
        get() = _stateData

    val successData: LiveData<T>
        get() = _successData

    val errorData: LiveData<Reason>
        get() = _errorData

    protected fun handleState(state: State) {
        _stateData.value = state
    }

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
