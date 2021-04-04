package com.example.syncdark.feature.changetheme

sealed class ChangeThemeIntent {
    data class CheckTheme(val isDarkTheme: Boolean) : ChangeThemeIntent()
    object OnClickChoiceTheme : ChangeThemeIntent()
    object OnSetDayTheme : ChangeThemeIntent()
    object OnSetNightTheme : ChangeThemeIntent()
    object OnSetSystemTheme : ChangeThemeIntent()
}
