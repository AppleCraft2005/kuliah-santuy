package com.android.modul5.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DarkModeViewMOdel(application: Application) : AndroidViewModel(application) {

    private val prefs: SharedPreferences = application.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    // StateFlow untuk isDarkMode
    private val _isDarkMode = MutableStateFlow(prefs.getBoolean("is_dark_mode", false))
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow() // Baca sebagai StateFlow

    // Fungsi untuk mengubah dark mode
    fun toggleDarkMode() {
        val newMode = !_isDarkMode.value // Membalikkan nilai saat ini
        _isDarkMode.value = newMode // Update StateFlow
        prefs.edit { putBoolean("is_dark_mode", newMode) } // Simpan ke SharedPreferences
    }
}