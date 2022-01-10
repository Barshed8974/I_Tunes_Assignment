package com.example.mock_assignment1.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assignment.myapplication.Source.Local.Music
import com.assignment.i_tunes_assignment.Source.Local.MusicDao
import com.example.mock_assignment1.Repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyViewModel ( musicDao: MusicDao) : ViewModel() {
    private val repository=MyRepository(musicDao)

    fun getDataFromDataBase(string: String):LiveData<List<Music>>
    {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getArtist(string)
        }
        return repository.getMusic()
    }

}