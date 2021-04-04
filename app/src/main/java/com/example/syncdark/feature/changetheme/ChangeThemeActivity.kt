package com.example.syncdark.feature.changetheme

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import com.example.syncdark.R
import com.example.syncdark.commom.ThemeChoiceDialog
import com.example.syncdark.utils.isDarkTheme
import kotlinx.android.synthetic.main.activity_main.*

class ChangeThemeActivity : AppCompatActivity() {

    private val factory = ChangeThemeViewModel.Factory()
    private val viewModel: ChangeThemeViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        setListeners()
        setObservers()
    }

    private fun setView() {
        viewModel.handle(ChangeThemeIntent.CheckTheme(isDarkTheme = isDarkTheme()))
    }

    private fun setListeners() = choiceThemeBt.setOnClickListener {
        viewModel.handle(ChangeThemeIntent.OnClickChoiceTheme)
    }

    private fun setObservers() = viewModel.state.observe(this) { state ->
        when (state) {
            ChangeThemeState.SetTextDay -> setHeader(R.string.hello_day_theme)
            ChangeThemeState.SetTextNight -> setHeader(R.string.hello_dark_theme)
            ChangeThemeState.ShowDialog -> showDialog()
            ChangeThemeState.SetDayTheme -> setDayTheme()
            ChangeThemeState.SetNightTheme -> setNightTheme()
            ChangeThemeState.SetSystemTheme -> setSystemTheme()
            ChangeThemeState.SetBatterySaverTheme -> setBatterySaverTheme()
        }
    }

    private fun setHeader(text: Int) {
        choiceThemeHeaderTv.text = getString(text)
    }

    private fun showDialog() = ThemeChoiceDialog(
        context = this,
        themeDayChoosed = { viewModel.handle(ChangeThemeIntent.OnSetDayTheme) },
        themeNightChoosed = { viewModel.handle(ChangeThemeIntent.OnSetNightTheme) },
        themeSystemChoosed = { viewModel.handle(ChangeThemeIntent.OnSetSystemTheme) }
    ).show()

    private fun setDayTheme() = setDefaultNightMode(MODE_NIGHT_NO)

    private fun setNightTheme() = setDefaultNightMode(MODE_NIGHT_YES)

    private fun setSystemTheme() = setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)

    private fun setBatterySaverTheme() = setDefaultNightMode(MODE_NIGHT_AUTO_BATTERY)
}