package umon.ui.test.binding

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.chetan.test.ui.R
/**
 * Inflates a binding layout and calls [init] on newly-created binding for that layout.
 */
inline fun <T : ViewDataBinding> inflate(
    @LayoutRes layout: Int,
    @StyleRes style: Int = R.style.Theme_AppCompat,
    init: T.() -> Unit
) {
    val context = ContextThemeWrapper(getApplicationContext(), style)
    val inflater = LayoutInflater.from(context)
    val parent = FrameLayout(context)

    val binding = DataBindingUtil.inflate<T>(inflater, layout, parent, true)
    binding.init()
}

/**
 * Executes pending binding right away.
 */
inline fun <T : ViewDataBinding> T.bind(init: () -> Unit) {
    init()
    executePendingBindings()
}

/**
 * Executes pending binding right away.
 */
inline fun <T : ViewDataBinding, S> T.bind(state: S?, init: S.() -> Unit) {
    state?.let {
        it.init()
        executePendingBindings()
    }
}

/**
 * Returns parent view of binding's root view.
 */
inline val <T : ViewDataBinding> T.parent: View
    get() = root.parent as View
