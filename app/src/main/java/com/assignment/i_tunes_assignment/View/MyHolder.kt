package com.example.mock_assignment1.View

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myapplication.Source.Local.Music
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class MyHolder(var itemview: View): RecyclerView.ViewHolder(itemview) {
    fun Setdata(music: Music)
    {
        itemview.name.text=music.author
        Glide.with(itemView.image).load(music.image).into(itemView.image)
       // Log.d("Adapter",music.image)
    }
}