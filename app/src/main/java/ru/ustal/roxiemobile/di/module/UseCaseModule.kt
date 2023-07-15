package ru.ustal.roxiemobile.di.module

import dagger.Module
import dagger.Provides
import ru.ustal.roxiemobile.domain.repository.OrderRepository
import ru.ustal.roxiemobile.domain.repository.PhotoRepository
import ru.ustal.roxiemobile.domain.repository.VideoRepository
import ru.ustal.roxiemobile.domain.usecases.GetOrdersUseCase
import ru.ustal.roxiemobile.domain.usecases.GetPhotosUseCase
import ru.ustal.roxiemobile.domain.usecases.GetVideosUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideOrderUseCase(repository: OrderRepository): GetOrdersUseCase {
        return GetOrdersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(repository: PhotoRepository): GetPhotosUseCase {
        return GetPhotosUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetVideosUseCase(repository: VideoRepository): GetVideosUseCase {
        return GetVideosUseCase(repository)
    }

}