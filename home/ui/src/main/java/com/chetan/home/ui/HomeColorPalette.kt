package com.chetan.home.ui

import androidx.annotation.ColorInt
import java.io.Serializable

/**
 * Data class to represent color palette for home.
 */
data class HomeColorPalette constructor(
    @ColorInt val primary: Int,
    @ColorInt val secondary: Int
) : Serializable {

    companion object {
        val DEFAULT = HomeColorPalette(0xfff, 0xfff)
    }
}
