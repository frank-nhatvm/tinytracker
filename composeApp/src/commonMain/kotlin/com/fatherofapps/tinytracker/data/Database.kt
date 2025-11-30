package com.fatherofapps.tinytracker.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [EventEntity::class, DailySummaryEntity::class], version = 1)
@ConstructedBy(TinyTrackerDBConstructor::class)
abstract class TinyTrackerDB : RoomDatabase() {
    abstract fun eventsDao(): EventsDao
    abstract fun dailySummaryDao(): DailySummaryDao
}

@Suppress("KotlinNoActualForExpect")
expect object TinyTrackerDBConstructor : RoomDatabaseConstructor<TinyTrackerDB> {
    override fun initialize(): TinyTrackerDB
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<TinyTrackerDB>
): TinyTrackerDB {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}