package com.example.playlistdmitry.data.repository

import com.example.playlistdmitry.domain.model.Track
import com.example.playlistdmitry.domain.repository.FavoritesRepository
import com.example.playlistdmitry.util.LocalStorage


class FavoritesRepositoryImpl(
    private val localStorage: LocalStorage
) : FavoritesRepository {


    override fun addTrackToFavorites(track: Track) {
        localStorage.addToFavorites(track.trackId)
    }


    override fun removeTrackFromFavorites(track: Track) {
        localStorage.removeFromFavorites(track.trackId)
    }


    override fun isTrackFavorite(trackId: Long): Boolean {
        return localStorage.getSavedFavorites().contains(trackId)
    }
}
