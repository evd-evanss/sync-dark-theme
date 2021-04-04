package com.example.syncdark.commom

import android.content.Context
import android.os.Bundle
import com.example.syncdark.R
import com.example.syncdark.base.BaseDialog
import kotlinx.android.synthetic.main.choice_theme_dialog.*

class ThemeChoiceDialog(
    context: Context,
    private val themeDayChoosed: (() -> Unit),
    private val themeNightChoosed: (() -> Unit),
    private val themeSystemChoosed: (() -> Unit)
) : BaseDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice_theme_dialog)
        setWidthToMatchWindowsSize()
        setListeners()
    }

    private fun setListeners() {
        themeChoiceCancelBt.setOnClickListener {
            dismiss()
        }
        themeChoiceGroupRg.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.themeChoiceDayRb -> themeDayChoosed()
                R.id.themeChoiceNightRb -> themeNightChoosed()
                R.id.themeChoiceSystemRb -> themeSystemChoosed()
            }
        }
    }

    private fun themeDayChoosed() {
        themeDayChoosed.invoke()
        dismiss()
    }

    private fun themeNightChoosed() {
        themeNightChoosed.invoke()
        dismiss()
    }

    private fun themeSystemChoosed() {
        themeSystemChoosed.invoke()
        dismiss()
    }
}