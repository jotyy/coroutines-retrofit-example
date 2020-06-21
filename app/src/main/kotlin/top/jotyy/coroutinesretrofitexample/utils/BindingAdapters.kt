package top.jotyy.coroutinesretrofitexample.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("writtenBy")
fun writtenBy(textView: TextView, author: String) {
    textView.text = "Written by $author"
}

@BindingAdapter("createdAt")
fun createdAt(textView: TextView, date: String) {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
    val time = sdf.parse(date)
    textView.text = SimpleDateFormat("MMM dd, yyyy", Locale.UK).format(time!!)
}

@BindingAdapter(
    "glideSrc",
    "glideCenterCrop",
    "glideCircularCrop",
    requireAll = false
)
fun ImageView.bindGlideSrc(
    url: String?,
    centerCrop: Boolean = false,
    circularCrop: Boolean = false
) {
    if (url == null) return

    createGlideRequest(
        context,
        url,
        centerCrop,
        circularCrop
    ).into(this)
}

fun createGlideRequest(
    context: Context,
    src: String,
    centerCrop: Boolean,
    circularCrop: Boolean
): RequestBuilder<Drawable> {
    val req = Glide.with(context).load(src)
    if (centerCrop) req.centerCrop()
    if (circularCrop) req.circleCrop()
    return req
}
