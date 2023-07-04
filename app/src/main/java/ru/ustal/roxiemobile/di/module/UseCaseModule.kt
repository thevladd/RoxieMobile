package ru.ustal.roxiemobile.di.module

import dagger.Module
import dagger.Provides
import ru.ustal.roxiemobile.domain.repository.ImageRepository
import ru.ustal.roxiemobile.domain.repository.OrderRepository
import ru.ustal.roxiemobile.domain.usecases.GetImageUseCase
import ru.ustal.roxiemobile.domain.usecases.GetOrdersUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetOrdersUseCase(repository: OrderRepository): GetOrdersUseCase {
        return GetOrdersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetImageUseCase(repository: ImageRepository): GetImageUseCase {
        return GetImageUseCase(repository)
    }

}