package top.jotyy.coroutinesretrofitexample.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyResponse<out T>(
    val code: Int,
    val msg: String,
    val data: T?
)