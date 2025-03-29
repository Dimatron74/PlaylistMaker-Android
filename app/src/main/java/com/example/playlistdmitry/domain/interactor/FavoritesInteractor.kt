package com.example.playlistdmitry.domain.interactor

import com.example.playlistdmitry.domain.model.Track

interface FavoritesInteractor {

    fun addTrackToFavorites(track: Track)

    fun removeTrackFromFavorites(track: Track)

    fun isTrackFavorite(trackId: Long): Boolean
}
