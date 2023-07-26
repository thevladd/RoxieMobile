package ru.ustal.roxiemobile.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.ustal.roxiemobile.App
import ru.ustal.roxiemobile.R
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.video.VideoModel
import ru.ustal.roxiemobile.domain.usecases.GetVideosUseCase
import ru.ustal.roxiemobile.utils.OperationResult
import javax.inject.Inject

class PixelsViewModel(val app: Application) : AndroidViewModel(app) {

    init {
        App.instance.appComponent.inject(this)
    }

    @Inject
    lateinit var getVideosUseCase: GetVideosUseCase

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _videos: MutableLiveData<OperationResult<List<VideoModel>>> = MutableLiveData()
    val videos: LiveData<OperationResult<List<VideoModel>>> = _videos

    fun initData() {
        disposable.add(
            getVideosUseCase.execute(
                path = "popular",
                params = PaginatedRequestParams(perPage = 50)
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.videos == null)
                        throw Throwable()
                    _videos.postValue(OperationResult.Success(data = it.videos))
                }, {
                    _videos.postValue(
                        OperationResult.OperationError(
                            it.message ?: app.getString(R.string.get_video_error)
                        )
                    )
                })
        )
    }

}