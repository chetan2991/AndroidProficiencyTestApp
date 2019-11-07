package com.chetan.base.ui.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.chetan.base.ui.Visibility
import com.chetan.base.ui.hideKeyboard
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import com.chetan.base.ui.di.GlideApp


/**
 * Sets [visibility][View.setVisibility] of the given view.
 */
@BindingAdapter("visibility")
fun View.setVisibility(visibility: Visibility) {
    when (visibility) {
        Visibility.VISIBLE -> this.visibility = View.VISIBLE
        Visibility.INVISIBLE -> this.visibility = View.INVISIBLE
        Visibility.GONE -> this.visibility = View.GONE
    }
}

/**
 * Binding adapter for on-click listener for view which also hide the keyboard before dispatching the event.
 */
@BindingAdapter("onClickHideKeyboard")
fun View.setOnClickHideKeyboardListener(listener: View.OnClickListener) {
    setOnClickListener {
        hideKeyboard()
        listener.onClick(it)
    }
}

@BindingAdapter("imageSrc")
fun View.loadImage(imageUrl: String?) {
    val glide = GlideApp.with(this)
    if ((imageUrl?.startsWith("http") == true) && (this is ImageView)) {
        this.visibility = View.VISIBLE
        glide.run {
            load(imageUrl)
                .apply(RequestOptions().centerCrop())
                .into((this@loadImage as ImageView ))
        }
    } else {
        this.visibility = View.GONE
        glide.clear(this)
    }
}
