package top.jotyy.coroutinesretrofitexample.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "user_name") val userName: String,
    @Json(name = "nick_name") val nickName: String
)
