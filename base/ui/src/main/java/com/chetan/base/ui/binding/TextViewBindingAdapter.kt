package com.chetan.base.ui.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter
import com.chetan.base.ui.Message
import com.chetan.base.ui.resolve


@SuppressLint("RestrictedApi")
@BindingAdapter("message")
fun TextView.setText(message: Message) {
    TextViewBindingAdapter.setText(this, message.resolve(context))
}
