package top.jotyy.coroutinesretrofitexample.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleEntity (
    val title: String,
    val content: String,
    val coverUrl: String
)