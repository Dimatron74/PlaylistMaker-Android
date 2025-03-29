package com.example.playlistdmitry.data.creator

import android.content.Context
import android.content.SharedPreferences
import com.example.playlistdmitry.data.SearchHistory
import com.example.playlistdmitry.data.network.ITunesApi
import com.example.playlistdmitry.data.network.RetrofitClient
import com.example.playlistdmitry.data.repository.FavoritesRepositoryImpl
import com.example.playlistdmitry.data.repository.TrackRepository
import com.example.playlistdmitry.data.repository.TrackRepositoryImpl
import com.example.playlistdmitry.data.settings.impl.ThemeSettingsRepositoryImpl
import com.example.playlistdmitry.data.sharing.impl.ExternalNavigatorImpl
import com.example.playlistdmitry.domain.interactor.FavoritesInteractor
import com.example.playlistdmitry.domain.interactor.SearchInteractor
import com.example.playlistdmitry.domain.interactor.ThemeSettingsInteractor
import com.example.playlistdmitry.domain.interactor.ThemeSettingsInteractorImpl
import com.example.playlistdmitry.domain.interactor.impl.FavoritesInteractorImpl
import com.example.playlistdmitry.domain.interactor.impl.SearchInteractorImpl
import com.example.playlistdmitry.domain.sharing.SharingInteractor
import com.example.playlistdmitry.domain.sharing.impl.SharingInteractorImpl
import com.example.playlistdmitry.util.LocalStorage


object Creator {


    private fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("search_prefs", Context.MODE_PRIVATE)
    }


    fun provideThemeSettingsInteractor(context: Context): ThemeSettingsInteractor {
        val repository = ThemeSettingsRepositoryImpl(provideSharedPreferences(context))
        return ThemeSettingsInteractorImpl(repository)
    }


    private fun provideITunesApi(): ITunesApi {
        return RetrofitClient.iTunesApiService
    }

    private fun provideSearchHistory(context: Context): SearchHistory {
        return SearchHistory(context)
    }


    private fun provideTrackRepository(context: Context): TrackRepository {
        return TrackRepositoryImpl(provideITunesApi(), provideSearchHistory(context))
    }
    fun provideTrackInteractor(context: Context): SearchInteractor {
        val repository = provideTrackRepository(context)
        return SearchInteractorImpl(repository)
    }
    fun provideSharingInteractor(context: Context): SharingInteractor {
        val externalNavigator = ExternalNavigatorImpl(context)
        return SharingInteractorImpl(externalNavigator, context)
    }
    fun provideFavoritesInteractor(context: Context): FavoritesInteractor {
        val localStorage =
            LocalStorage(context.getSharedPreferences("local_storage", Context.MODE_PRIVATE))
        val repository = FavoritesRepositoryImpl(localStorage)
        return FavoritesInteractorImpl(repository)
    }
}
