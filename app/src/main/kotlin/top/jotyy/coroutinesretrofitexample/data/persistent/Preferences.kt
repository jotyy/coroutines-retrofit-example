package top.jotyy.coroutinesretrofitexample.data.persistent

interface Preferences {

    fun getToken(): String

    fun setToken(token: String)

}