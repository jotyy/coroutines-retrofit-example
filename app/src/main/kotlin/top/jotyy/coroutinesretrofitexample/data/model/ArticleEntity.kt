package top.jotyy.coroutinesretrofitexample.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ArticleEntity(
    val title: String,
    val desc: String,
    val content: String,
    @Json(name = "cover_url") val coverUrl: String,
    @Json(name = "created_by") val createdBy: String,
    @Json(name = "CreatedAt") val createdAt: String
) : Serializable
