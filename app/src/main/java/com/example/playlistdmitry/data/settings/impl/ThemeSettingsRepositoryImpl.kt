
package com.example.playlistdmitry.data.settings.impl

import android.content.SharedPreferences
import com.example.playlistdmitry.domain.repository.ThemeSettingsRepository


class ThemeSettingsRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : ThemeSettingsRepository {

    override fun getThemeSettings(): Boolean {


        return sharedPreferences.getBoolean("dark_theme", false)
    }

    override fun updateThemeSettings(isDarkTheme: Boolean) {


        sharedPreferences.edit().putBoolean("dark_theme", isDarkTheme).apply()
    }
}