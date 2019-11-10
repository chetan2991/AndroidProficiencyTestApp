package com.chetan.base.data

import com.chetan.base.data.network.NetworkClient
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import retrofit2.Retrofit

class NetworkClientTest {

    interface TestService

    @Test
    fun returnInstanceOfService_whenCase1() {
        // GIVEN
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/")
            .build()
        val client = NetworkClient(retrofit)

        // WHEN
        val testService = client.create(TestService::class)

        // THEN
        assertThat(testService, instanceOf(TestService::class.java))
    }
}
