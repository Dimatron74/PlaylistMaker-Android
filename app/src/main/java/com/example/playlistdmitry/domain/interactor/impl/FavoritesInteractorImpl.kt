package com.example.playlistdmitry.domain.interactor.impl

import com.example.playlistdmitry.domain.interactor.FavoritesInteractor
import com.example.playlistdmitry.domain.model.Track
import com.example.playlistdmitry.domain.repository.FavoritesRepository
class FavoritesInteractorImpl(
    private val repository: FavoritesRepository
) : FavoritesInteractor {
    override fun addTrackToFavorites(track: Track) {
        repository.addTrackToFavorites(track)
    }
    override fun removeTrackFromFavorites(track: Track) {
        repository.removeTrackFromFavorites(track)
    }
    override fun isTrackFavorite(trackId: Long): Boolean {
        return repository.isTrackFavorite(trackId)
    }
}
