package com.chetan.base.ui.binding

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.base.ui.Visibility
import com.chetan.test.ui.themedContext
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewBindingAdapterTest {

    private val view = View(themedContext())

    @Test
    fun shouldMakeViewVisible() {
        // GIVEN
        view.visibility = View.GONE

        // WHEN
        view.setVisibility(Visibility.VISIBLE)

        // THEN
        assertThat(view.visibility, equalTo(View.VISIBLE))
    }

    @Test
    fun shouldMakeViewInvisible() {
        // GIVEN
        view.visibility = View.VISIBLE

        // WHEN
        view.setVisibility(Visibility.INVISIBLE)

        // THEN
        assertThat(view.visibility, equalTo(View.INVISIBLE))
    }

    @Test
    fun shouldMakeViewGone() {
        // GIVEN
        view.visibility = View.VISIBLE

        // WHEN
        view.setVisibility(Visibility.GONE)

        // THEN
        assertThat(view.visibility, equalTo(View.GONE))
    }

    @Test
    fun shouldCallOnClickListener() {
        // GIVEN
        val mockedListener = mock<View.OnClickListener>()
        view.setOnClickHideKeyboardListener(mockedListener)

        // WHEN
        view.performClick()

        // THEN
        verify(mockedListener).onClick(view)
    }
}
