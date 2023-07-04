package ru.ustal.roxiemobile.di.module

import dagger.Module
import dagger.Provides
import ru.ustal.roxiemobile.domain.repository.OrderRepository
import ru.ustal.roxiemobile.domain.usecases.GetOrdersUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideOrderUseCase(repository: OrderRepository): GetOrdersUseCase {
        return GetOrdersUseCase(repository)
    }

}