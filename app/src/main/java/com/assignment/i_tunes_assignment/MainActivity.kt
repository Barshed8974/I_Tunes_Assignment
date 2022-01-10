package com.assignment.i_tunes_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.assignment.i_tunes_assignment.ViewModel.MyViewModelFactory
import com.assignment.myapplication.Source.Local.MusicDB
import com.example.mock_assignment1.View.MyAdapter
import com.example.mock_assignment1.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel=ViewModelProvider(this@MainActivity,
            MyViewModelFactory(MusicDB.getDatabaseObject(this@MainActivity).
            getTaskDAO())).get(MyViewModel::class.java)
            search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!=null)
                {
                    viewModel.getDataFromDataBase(newText).observe(this@MainActivity,{
                        recycler.adapter=MyAdapter(this@MainActivity,it)
                        Log.d("MyApp",it.size.toString())
                    })
                    recycler.layoutManager=GridLayoutManager(this@MainActivity,3)
                }
                return false
            }
        })
    }
}