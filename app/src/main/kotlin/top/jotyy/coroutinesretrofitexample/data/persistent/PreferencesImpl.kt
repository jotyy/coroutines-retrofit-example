package top.jotyy.coroutinesretrofitexample.data.persistent

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class PreferencesImpl @Inject constructor(
    private val context: Context
) : Preferences {
    companion object {
        const val APP_SHARE = "coroutines_demo"
        const val TOKEN = "token"
    }

    private val mPrefs = context.getSharedPreferences(APP_SHARE, Context.MODE_PRIVATE)

    override fun getToken(): String =
        mPrefs.getString(TOKEN, "")!!

    override fun setToken(token: String) =
        mPrefs.edit(true) { putString(TOKEN, token) }

}