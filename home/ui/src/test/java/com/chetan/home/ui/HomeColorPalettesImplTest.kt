package com.chetan.home.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeColorPalettesImplTest {

    @Test
    fun shouldReturnPalette() {
        // GIVEN
        val expectedPalette1 = HomeColorPalette(0x000, 0x000)
        val expectedPalette2 = HomeColorPalette(0xfff, 0xfff)
        val palettes = listOf(expectedPalette1, expectedPalette2)
        val palette = HomeColorPalettesImpl(palettes)

        // WHEN
        val palette1 = palette.get(0)
        val palette2 = palette.get(1)
        val palette3 = palette.get(2)
        val palette4 = palette.get(3)

        // THEN
        assertThat(palette1, equalTo(expectedPalette1))
        assertThat(palette2, equalTo(expectedPalette2))
        assertThat(palette3, equalTo(expectedPalette1))
        assertThat(palette4, equalTo(expectedPalette2))
    }
}
