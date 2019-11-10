package com.chetan.base.ui.binding

import android.R
import android.widget.TextView
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.base.domain.ErrorMessage
import com.chetan.base.domain.ExceptionWrapper
import com.chetan.base.ui.Message
import com.chetan.test.ui.themedContext
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TextViewBindingAdapterTest {

    @Test
    fun shouldSetTextFromStringResource() {
        // GIVEN
        val textView = TextView(themedContext())
        val message = Message(R.string.ok)

        // WHEN
        textView.setText(message)

        // THEN
        assertThat(textView, withText(R.string.ok))
    }

    @Test
    fun shouldSetTextFromErrorMessage() {
        // GIVEN
        val textView = TextView(themedContext())
        val expectedMessage = "Error Message"
        val message = Message(
            messageId = R.string.ok,
            error = ExceptionWrapper(
                errorMessage = ErrorMessage(expectedMessage),
                cause = RuntimeException()
            )
        )
        // WHEN
        textView.setText(message)

        // THEN
        assertThat(textView, withText(expectedMessage))
    }
}
