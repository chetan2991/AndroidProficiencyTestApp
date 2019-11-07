package com.chetan.home.ui

import android.app.Application
import androidx.core.content.ContextCompat.getColor
import javax.inject.Inject

/**
 * Provides [HomeColorPalette] based on the given index.
 */
interface HomeColorPalettes {
    fun get(index: Int): HomeColorPalette
}

class HomeColorPalettesImpl constructor(
    private val palettes: List<HomeColorPalette>
) : HomeColorPalettes {

    @Inject
    constructor(app: Application) : this(
        listOf(
            HomeColorPalette(getColor(app, R.color.light_blue), getColor(app, R.color.light_blue)),
            HomeColorPalette(getColor(app, R.color.soft_pink), getColor(app, R.color.soft_pink)),
            HomeColorPalette(
                getColor(app, R.color.pale_salmon),
                getColor(app, R.color.pale_salmon)
            ),
            HomeColorPalette(
                getColor(app, R.color.light_salmon),
                getColor(app, R.color.light_salmon)
            ),
            HomeColorPalette(
                getColor(app, R.color.pastel_blue),
                getColor(app, R.color.pastel_blue)
            ),
            HomeColorPalette(
                getColor(app, R.color.floral_green),
                getColor(app, R.color.floral_green)
            )
        )
    )

    override fun get(index: Int): HomeColorPalette {
        return palettes[index % palettes.size]
    }
}
