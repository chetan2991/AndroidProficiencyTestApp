package com.chetan.base.ui.binding

import androidx.databinding.BaseObservable
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class BindDelegateTest {

    @Test
    fun shouldReturnInitialValue() {
        val expectedValue = "Init Data"
        val delegate = BindDelegate(1, expectedValue, { _, _ -> })

        val actualValue = delegate.getValue(mock(), mock())

        assertThat(actualValue, equalTo(expectedValue))
    }

    @Test
    fun shouldUpdateValue() {
        val expectedValue = "Updated Data"
        val delegate = BindDelegate(1, "Init Data", { _, _ -> })

        delegate.setValue(mock(), mock(), expectedValue)

        assertThat(delegate.getValue(mock(), mock()), equalTo(expectedValue))
    }

    @Test
    fun shouldNotifyPropertyChanged_whenValueChanged() {
        val expectedFieldId = 1
        val mockedObservable = mock<BaseObservable>()
        val delegate = BindDelegate(expectedFieldId, "Init Data", { _, _ -> })

        delegate.setValue(mockedObservable, mock(), "Updated Data")

        verify(mockedObservable).notifyPropertyChanged(expectedFieldId)
    }

    @Test
    fun shouldNotNotifyPropertyChanged_whenValueNotChanged() {
        val value = "Init Data"
        val mockedObservable = mock<BaseObservable>()
        val delegate = BindDelegate(1, value, { _, _ -> })

        delegate.setValue(mockedObservable, mock(), value)

        verify(mockedObservable, never()).notifyPropertyChanged(any())
    }

    @Test
    fun shouldCallOnChange_whenValueChanged() {
        val oldValue = "Init Data"
        val newValue = "Updated Data"
        val mockedOnChange = mock<(String, String) -> Unit>()
        val delegate = BindDelegate(1, oldValue, mockedOnChange)

        delegate.setValue(mock(), mock(), newValue)

        verify(mockedOnChange).invoke(oldValue, newValue)
    }

    @Test
    fun shouldNotCallOnChange_whenValueNotChanged() {
        val value = "Init Data"
        val mockedOnChange = mock<(String, String) -> Unit>()
        val delegate = BindDelegate(1, value, mockedOnChange)

        delegate.setValue(mock(), mock(), value)

        verify(mockedOnChange, never()).invoke(any(), any())
    }
}
