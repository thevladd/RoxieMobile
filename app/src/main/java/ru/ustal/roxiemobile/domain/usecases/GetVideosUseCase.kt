package ru.ustal.roxiemobile.domain.usecases

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.video.VideosModel
import ru.ustal.roxiemobile.domain.repository.VideoRepository

class GetVideosUseCase(private val videoRepository: VideoRepository) {

    //TODO Заменить возвращаемую модельку на модельку для вью
    fun execute(path: String, params: PaginatedRequestParams? = null): Single<VideosModel> {
        return videoRepository.getVideos(path = path, params = params)
    }
}