package com.example.playlistdmitry.domain.interactor
interface ThemeSettingsInteractor {
    fun getThemeSettings(): Boolean
    fun setDarkThemeEnabled(isEnabled: Boolean)
}