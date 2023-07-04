package ru.ustal.roxiemobile

import android.app.Application
import ru.ustal.roxiemobile.di.AppComponent
import ru.ustal.roxiemobile.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
        fun get(): App {
            return instance
        }
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(this)
    }

}