
package com.example.playlistdmitry.domain.interactor

import com.example.playlistdmitry.domain.model.Track
interface SearchInteractor {
    suspend fun searchSongs(query: String): List<Track>
    fun saveSearchHistory(track: Track)
    fun getSearchHistory(): List<Track>
    fun clearSearchHistory()
}