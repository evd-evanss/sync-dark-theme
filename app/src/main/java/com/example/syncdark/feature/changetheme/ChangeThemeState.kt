package com.example.syncdark.feature.changetheme

sealed class ChangeThemeState {
    object ShowDialog : ChangeThemeState()
    object SetDayTheme : ChangeThemeState()
    object SetNightTheme : ChangeThemeState()
    object SetSystemTheme : ChangeThemeState()
    object SetBatterySaverTheme : ChangeThemeState()
    object SetTextDay : ChangeThemeState()
    object SetTextNight : ChangeThemeState()
}
