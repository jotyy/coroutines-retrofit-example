package top.jotyy.coroutinesretrofitexample.data.source

import top.jotyy.coroutinesretrofitexample.data.persistent.Preferences
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val preferences: Preferences
) {

    fun setToken(token: String) = preferences.setToken(token)

    fun getToken() = preferences.getToken()
}
