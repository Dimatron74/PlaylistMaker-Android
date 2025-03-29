package com.example.playlistdmitry.domain.repository
interface ThemeSettingsRepository {
    fun getThemeSettings(): Boolean
    fun updateThemeSettings(settings: Boolean)
}
