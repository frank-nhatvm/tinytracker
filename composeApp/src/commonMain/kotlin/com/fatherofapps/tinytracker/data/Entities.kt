package com.fatherofapps.tinytracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
   @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val time: Long,
    val metaData: String?  = null
)

@Entity
data class DailySummaryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: Long,
    val count: Int,
    val metaData: String?  = null
)