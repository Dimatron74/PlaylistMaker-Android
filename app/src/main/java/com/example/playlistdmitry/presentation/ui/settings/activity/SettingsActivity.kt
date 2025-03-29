package com.example.playlistdmitry.presentation.ui.settings.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.playlistdmitry.R
import com.example.playlistdmitry.presentation.ui.settings.view_model.SettingsViewModel
import com.example.playlistdmitry.util.App
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textview.MaterialTextView
class SettingsActivity : AppCompatActivity() {
    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModel.getViewModelFactory(applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val toolbar = findViewById<Toolbar>(R.id.settings_toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        val themeSwitcher = findViewById<SwitchMaterial>(R.id.switch_setting)
        themeSwitcher.isChecked = settingsViewModel.isDarkTheme.value ?: false
        settingsViewModel.isDarkTheme.observe(this) { isDarkTheme ->
            themeSwitcher.isChecked = isDarkTheme
        }
        themeSwitcher.setOnCheckedChangeListener { _, isChecked ->
            settingsViewModel.setDarkThemeEnabled(isChecked)
            (applicationContext as App).switchTheme(isChecked)
        }
        val shareButton = findViewById<MaterialTextView>(R.id.share_button)
        shareButton.setOnClickListener {
            settingsViewModel.shareApp()
        }
        val supportButton = findViewById<MaterialTextView>(R.id.write_to_tech_support_button)
        supportButton.setOnClickListener {
            settingsViewModel.openSupport()
        }
        val userAgreementButton = findViewById<MaterialTextView>(R.id.user_agreement_button)
        userAgreementButton.setOnClickListener {
            settingsViewModel.openTerms()
        }

    }
}
