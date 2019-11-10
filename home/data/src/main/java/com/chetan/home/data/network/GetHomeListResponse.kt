package com.chetan.home.data.network

import com.chetan.base.data.network.Json
import com.chetan.home.domain.model.Fact

@Json
data class GetHomeListResponse(
    val rows: List<Fact>,
    val title: String
)




