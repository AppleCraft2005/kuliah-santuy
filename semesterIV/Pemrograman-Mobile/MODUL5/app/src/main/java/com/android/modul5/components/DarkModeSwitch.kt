package com.android.modul5.components

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.modul5.viewmodel.DarkModeViewMOdel

@Composable
fun DarkModeSwitch() {
    val DarkModeViewMOdel: DarkModeViewMOdel = viewModel()
    val isDarkMode by DarkModeViewMOdel.isDarkMode.collectAsState()

    Switch(
        checked = isDarkMode,      // Mengikat status Switch ke variabel isDarkMode
        onCheckedChange = { DarkModeViewMOdel.toggleDarkMode() } // Mengirim nilai baru ke callback onToggle saat Switch digeser
    )
}