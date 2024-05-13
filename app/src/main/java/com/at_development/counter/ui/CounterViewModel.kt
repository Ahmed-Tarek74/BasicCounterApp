package com.at_development.counter.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.at_development.domain.usecases.CounterUseCase

@Suppress("UNCHECKED_CAST")
class CounterViewModel(private val counterUseCase: CounterUseCase) :ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter : LiveData<Int> = _counter
     fun increaseCounter() {
         val currentValue = _counter.value ?: 0
        _counter.value= counterUseCase.incrementCounter(currentValue)
    }
     fun decreaseCounter() {
         val currentValue = _counter.value ?: 0
        _counter.value=counterUseCase.decrementCounter(currentValue)
    }
     fun resetCounter(){
        _counter.value=counterUseCase.resetCounter()
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val counterHandler=CounterUseCase()
                return CounterViewModel(counterHandler) as T
            }
        }
    }

}