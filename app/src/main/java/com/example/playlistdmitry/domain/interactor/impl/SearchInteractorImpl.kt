package com.example.playlistdmitry.domain.interactor.impl

import com.example.playlistdmitry.data.repository.TrackRepository
import com.example.playlistdmitry.domain.interactor.SearchInteractor
import com.example.playlistdmitry.domain.model.Track
class SearchInteractorImpl(
    private val repository: TrackRepository
) : SearchInteractor {
    override suspend fun searchSongs(query: String): List<Track> {
        return repository.searchSongs(query)
    }
    override fun saveSearchHistory(track: Track) {
        repository.saveTrack(track)
    }
    override fun getSearchHistory(): List<Track> {
        return repository.getTrackHistory()
    }
    override fun clearSearchHistory() {
        repository.clearHistory()
    }
}