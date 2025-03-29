package com.example.playlistdmitry.data.network

import com.example.playlistdmitry.data.model.TrackSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ITunesApi {
    @GET("/search?entity=song")
    fun searchSongs(@Query("term") text: String): Call<TrackSearchResponse>
}
