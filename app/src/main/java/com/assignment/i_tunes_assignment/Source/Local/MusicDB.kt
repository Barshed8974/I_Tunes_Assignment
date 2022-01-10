package com.assignment.myapplication.Source.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.assignment.i_tunes_assignment.Source.Local.MusicDao


@Database(entities = [Music::class],version = 3)
abstract class MusicDB : RoomDatabase() {
    abstract fun getTaskDAO(): MusicDao
    companion object {

        private var INSTANCE: MusicDB? = null

        fun getDatabaseObject(context: Context): MusicDB {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    MusicDB::class.java,
                    "News_DB"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}
