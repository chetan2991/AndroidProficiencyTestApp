package com.chetan.home.data.db

import androidx.paging.DataSource
import com.chetan.home.domain.model.Fact
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * Class that handles the DAO local data source. This ensures that methods are triggered on the
 * with coroutine
 */
class FactLocalCacheImpl @Inject constructor(
    private val factDao: FactDao,
    private val scope: CoroutineScope
) : FactLocalCahe {
    override fun deleteAll(deleteFinished: () -> Unit) {
        scope.launch {
            factDao.deleteAll()
            deleteFinished()
        }
    }

    override fun insert(movies: List<Fact>, insertFinished: () -> Unit) {
        scope.launch {
            factDao.insert(movies)
            insertFinished()
        }
    }

    override fun getFacts(): DataSource.Factory<Int, Fact> {
        return factDao.getAllFact()
    }


}
