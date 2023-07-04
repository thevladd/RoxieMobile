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
import ru.ustal.roxiemobile.domain.model.BitmapModel
import ru.ustal.roxiemobile.domain.usecases.GetImageUseCase
import ru.ustal.roxiemobile.utils.OperationResult
import javax.inject.Inject

class OrderDetailViewModel(private val app: Application) : AndroidViewModel(app) {

    init {
        App.instance.appComponent.inject(this)
    }

    @Inject
    lateinit var getImageUseCase: GetImageUseCase

    private val _image: MutableLiveData<OperationResult<BitmapModel>> = MutableLiveData()
    val image: LiveData<OperationResult<BitmapModel>> = _image

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun getImage(url: String) {
        disposable.add(
            getImageUseCase.execute(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _image.postValue(OperationResult.Success(it))
                }, {
                    _image.postValue(
                        OperationResult.OperationError(
                            it.message ?: app.getString(R.string.get_image_error)
                        )
                    )
                })
        )
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}