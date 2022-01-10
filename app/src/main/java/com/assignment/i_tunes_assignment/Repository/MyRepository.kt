package com.example.mock_assignment1.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.assignment.myapplication.Source.Local.Music
import com.assignment.i_tunes_assignment.Source.Local.MusicDao
import com.assignment.myapplication.Source.Remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository (private  val musicDao: MusicDao, ) {
    suspend fun getArtist( string: String ) {
        try {
            Network.getApiServices().getArtist(string).results.forEach {
                addMusic(
                   Music(it.artistName,it.artworkUrl100)
                )
            }
        }catch (esc: Exception)
        {
            getMusic()
        }
        Log.d("ALI", "ll")
    }
    fun addMusic(music: Music)
    {
        Log.d("Myapp","${music.author}")
        CoroutineScope(Dispatchers.IO).launch {
            musicDao.addMusic(music) }
        musicDao.addMusic(music)
    }
    fun getMusic() : LiveData<List<Music>> {
        return musicDao.getMusic()
    }
}