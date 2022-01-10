package com.assignment.i_tunes_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.i_tunes_assignment.Source.Local.MusicDao
import com.example.mock_assignment1.ViewModel.MyViewModel

class MyViewModelFactory (private val musicDao: MusicDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ALI","Factory")
        return MyViewModel( musicDao) as T
    }
}