package ru.ustal.roxiemobile.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.ustal.roxiemobile.App

class PixelsViewModel(app: Application) : AndroidViewModel(app) {

    init {
        App.instance.appComponent.inject(this)
    }

    fun initData() {

    }

}