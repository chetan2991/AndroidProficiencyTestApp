package com.chetan.home.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.chetan.home.domain.model.Fact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(Fact::class), version = 1
    , exportSchema = false
)
abstract class FactDatabase : RoomDatabase() {

    abstract fun factDao(): FactDao

    private class FactDataBaseCallBack(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch {
                    var factDao = it.factDao()
                    factDao.deleteAll()
                }

            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FactDatabase? = null

        fun getDatabase(
            contex: Context,
            scope: CoroutineScope
        ): FactDatabase {
            val factDBInstance = INSTANCE

            if (factDBInstance != null) {
                return factDBInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    contex.applicationContext,
                    FactDatabase::class.java,
                    "fact_database"
                ).addCallback(FactDataBaseCallBack(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }
}