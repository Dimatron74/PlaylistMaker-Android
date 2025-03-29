package com.example.playlistdmitry.domain.interactor

import com.example.playlistdmitry.domain.repository.ThemeSettingsRepository
class ThemeSettingsInteractorImpl(
    private val repository: ThemeSettingsRepository
) : ThemeSettingsInteractor {
    override fun getThemeSettings(): Boolean {
        return repository.getThemeSettings()
    }
    override fun setDarkThemeEnabled(isEnabled: Boolean) {
        repository.updateThemeSettings(isEnabled)
    }
}
