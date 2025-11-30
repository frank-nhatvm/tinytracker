package com.fatherofapps.tinytracker.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// shared/src/androidMain/kotlin/Database.android.kt

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<TinyTrackerDB> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("fatherofapps_tinytracker.db")
    return Room.databaseBuilder<TinyTrackerDB>(
        context = appContext,
        name = dbFile.absolutePath
    )
}