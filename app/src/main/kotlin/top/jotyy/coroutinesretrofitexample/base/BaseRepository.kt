package top.jotyy.coroutinesretrofitexample.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import top.jotyy.coroutinesretrofitexample.data.Result
import top.jotyy.coroutinesretrofitexample.data.State

abstract class BaseRepository {

    protected suspend fun <T> execute(
        block: suspend () -> Result<T>
    ) = flow<Result<T>> {
        emit(State.Loading())
        emit(block())
        emit(State.Loaded())
    }

}
