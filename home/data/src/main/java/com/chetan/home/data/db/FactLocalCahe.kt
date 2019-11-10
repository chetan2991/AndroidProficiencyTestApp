package com.chetan.home.data.db

import androidx.paging.DataSource
import com.chetan.home.domain.model.Fact

interface FactLocalCahe {
    fun insert(facts: List<Fact>, insertFinished: () -> Unit)
    fun getFacts(): DataSource.Factory<Int, Fact>
    fun deleteAll(deleteFinished : ()->Unit)
}