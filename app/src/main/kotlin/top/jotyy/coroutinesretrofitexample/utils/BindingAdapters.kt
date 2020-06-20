package top.jotyy.coroutinesretrofitexample.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat

@BindingAdapter("writtenBy")
fun writtenBy(textView: TextView, author: String) {
    textView.text = "by $author"
}

@BindingAdapter("createdAt")
fun createdAt(textView: TextView, date: String) {
    textView.text = date
}