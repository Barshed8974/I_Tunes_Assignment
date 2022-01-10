package com.example.mock_assignment1.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.i_tunes_assignment.Model.Result
import com.assignment.i_tunes_assignment.R
import com.assignment.myapplication.Source.Local.Music

class MyAdapter(val context: Context,val list: List<Music>) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.Setdata(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}