package com.chetan.home.data.db

import androidx.paging.DataSource
import androidx.room.*
import com.chetan.home.domain.model.Fact

@Dao
interface FactDao {

    @Query("select * from fact order by title Asc")
    fun getAllFact(): DataSource.Factory<Int, Fact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fact: List<Fact>)

    @Query("delete  from fact")
    suspend fun deleteAll()

}