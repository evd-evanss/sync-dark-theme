package com.example.syncdark.feature.changetheme

import com.example.syncdark.base.BaseFactory
import com.example.syncdark.base.BaseViewModel

class ChangeThemeViewModel : BaseViewModel<ChangeThemeIntent, ChangeThemeState>() {

    override fun handle(intent: ChangeThemeIntent) {
        when(intent) {
            is ChangeThemeIntent.CheckTheme -> checkTheme(intent.isDarkTheme)
            ChangeThemeIntent.OnClickChoiceTheme -> _state.value = ChangeThemeState.ShowDialog
            ChangeThemeIntent.OnSetDayTheme -> _state.value = ChangeThemeState.SetDayTheme
            ChangeThemeIntent.OnSetNightTheme -> _state.value = ChangeThemeState.SetNightTheme
            ChangeThemeIntent.OnSetSystemTheme -> setSystemTheme()
        }
    }

    private fun checkTheme(isDarkTheme: Boolean) {
        if(!isDarkTheme) {
            _state.value = ChangeThemeState.SetTextDay
        } else {
            _state.value = ChangeThemeState.SetTextNight
        }
    }

    private fun setSystemTheme() {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            _state.value = ChangeThemeState.SetSystemTheme
        } else {
            _state.value = ChangeThemeState.SetBatterySaverTheme
        }
    }

    class Factory: BaseFactory(block = { ChangeThemeViewModel() })
}