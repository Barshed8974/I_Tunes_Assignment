package com.assignment.i_tunes_assignment.Source.Local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.assignment.myapplication.Source.Local.Music


@Dao
interface MusicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMusic(news: Music)

    @Query("select * from newsDataBase ")
    fun getMusic(): LiveData<List<Music>>

}
