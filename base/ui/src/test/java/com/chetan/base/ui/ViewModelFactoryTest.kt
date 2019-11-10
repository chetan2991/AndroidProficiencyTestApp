package com.chetan.base.ui

import androidx.lifecycle.ViewModel
import com.chetan.base.ui.ViewModelFactory
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Test
import javax.inject.Provider

class ViewModelFactoryTest {

    @Test
    fun returnsViewModel() {
        // GIVEN
        val factory = ViewModelFactory(mapOf(
            TestViewModel::class.java to Provider<ViewModel> { TestViewModel() }
        ))

        // WHEN
        val viewModel = factory.create(TestViewModel::class.java)

        // THEN
        assertThat(viewModel, instanceOf(TestViewModel::class.java))
    }

    @Test
    fun returnsAssignableViewModel() {
        // GIVEN
        val factory = ViewModelFactory(mapOf(
            ChildTestViewModel::class.java to Provider<ViewModel> { ChildTestViewModel() }
        ))

        // WHEN
        val viewModel = factory.create(TestViewModel::class.java)

        // THEN
        assertThat(viewModel, instanceOf(ChildTestViewModel::class.java))
    }

    @Test
    fun throwsException_whenMapIsEmpty() {
        // GIVEN
        val factory = ViewModelFactory(mapOf())

        try {
            // WHEN
            factory.create(TestViewModel::class.java)
            fail("exception not thrown")
        } catch (e: IllegalStateException) {
            // THEN
            // success
        }
    }

    private open class TestViewModel : ViewModel()
    private class ChildTestViewModel : TestViewModel()
}
