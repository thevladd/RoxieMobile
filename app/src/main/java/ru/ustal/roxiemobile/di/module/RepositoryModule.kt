package ru.ustal.roxiemobile.di.module

import dagger.Module
import dagger.Provides
import ru.ustal.roxiemobile.data.remote.RoxiApi
import ru.ustal.roxiemobile.data.repository.OrderRepositoryImpl
import ru.ustal.roxiemobile.domain.repository.OrderRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideOrderRepository(api: RoxiApi): OrderRepository {
        return OrderRepositoryImpl(api)
    }

}