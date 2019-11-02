package com.chetan.ui.event

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class EventTest {
    @Test
    fun shouldConsumedEventWhenConsumePerformed(){
        //given
        val event = Event("splash event")

        //when
        event.consume {  }

        //then
        assertThat(event.consumed, equalTo(true))
    }
    @Test
    fun shouldCallConsumerOnce_WhenEventConsumed(){
        val event = Event("splash event")
        val mockedConsumer = mock<(Event<String>) -> Unit>()
        event.consume(mockedConsumer)
        verify(mockedConsumer).invoke(event)
    }

    @Test
    fun shouldNeverCallConsumer_whenEventIsConsumed() {
        val event = Event("splash event")
        val mockedConsumer = mock<(Event<String>) -> Unit>()
        event.consume {}

        event.consume(mockedConsumer)

        verify(mockedConsumer, never()).invoke(any())
    }
}