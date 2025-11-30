package com.fatherofapps.tinytracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {
    @Insert
    suspend fun insert(event: EventEntity)

    @Delete
    suspend fun delete(event: EventEntity)

    @Query("SELECT * FROM EventEntity WHERE time = :day")
    fun eventsForDay(day: Long): Flow<List<EventEntity>>
}

@Dao
interface DailySummaryDao {

    @Insert
    suspend fun insert(entity: DailySummaryEntity)

    @Update
    suspend fun update(entity: DailySummaryEntity)

    @Delete
    suspend fun delete(entity: DailySummaryEntity)

    @Query("SELECT * FROM DailySummaryEntity WHERE date = :day")
    fun summaryFor(day: Long): Flow<List<DailySummaryEntity>>
}