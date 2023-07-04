package ru.ustal.roxiemobile.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.ustal.roxiemobile.di.module.NetworkModule
import ru.ustal.roxiemobile.di.module.RepositoryModule
import ru.ustal.roxiemobile.di.module.UseCaseModule
import ru.ustal.roxiemobile.presentation.viewModel.OrderDetailViewModel
import ru.ustal.roxiemobile.presentation.viewModel.OrdersViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

    fun inject(vm: OrderDetailViewModel)
    fun inject(vm: OrdersViewModel)

}