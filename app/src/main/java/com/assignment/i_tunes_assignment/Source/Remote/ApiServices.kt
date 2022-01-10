package com.assignment.myapplication.Source.Remote

import com.assignment.i_tunes_assignment.Model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/search")
    suspend fun getArtist(@Query("term") term:String) : ResponseModel
}
