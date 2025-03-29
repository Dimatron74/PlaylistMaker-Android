package com.example.playlistdmitry.data.repository

import com.example.playlistdmitry.domain.model.Track

interface TrackRepository {

    suspend fun searchSongs(query: String): List<Track>

    fun saveTrack(track: Track)

    fun getTrackHistory(): List<Track>

    fun clearHistory()
}