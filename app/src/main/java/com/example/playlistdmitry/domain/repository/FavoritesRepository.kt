package com.example.playlistdmitry.domain.repository

import com.example.playlistdmitry.domain.model.Track
interface FavoritesRepository {
    fun addTrackToFavorites(track: Track)
    fun removeTrackFromFavorites(track: Track)
    fun isTrackFavorite(trackId: Long): Boolean
}
