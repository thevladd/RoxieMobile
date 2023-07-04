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
import ru.ustal.roxiemobile.domain.model.view.OrderModelView
import ru.ustal.roxiemobile.domain.usecases.GetOrdersUseCase
import ru.ustal.roxiemobile.utils.OperationResult
import javax.inject.Inject

class OrdersViewModel(private val app: Application) : AndroidViewModel(app) {

    init {
        App.instance.appComponent.inject(this)
    }

    @Inject
    lateinit var getOrdersUseCase: GetOrdersUseCase

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _orders: MutableLiveData<OperationResult<List<OrderModelView>>> = MutableLiveData()
    val orders: LiveData<OperationResult<List<OrderModelView>>> = _orders

    fun initData() {
        disposable.add(
            getOrdersUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _orders.postValue(OperationResult.Success(it))
                }, {
                    _orders.postValue(
                        OperationResult.OperationError(
                            it.message ?: app.getString(R.string.get_order_error)
                        )
                    )
                })
        )
    }

    fun getOrderByPosition(position: Int): OrderModelView? {
        return if (_orders.value is OperationResult.Success)
            (_orders.value as OperationResult.Success<List<OrderModelView>>).data[position]
        else null
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}