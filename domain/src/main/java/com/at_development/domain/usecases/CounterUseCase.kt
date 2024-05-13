package com.at_development.domain.usecases

class CounterUseCase {

    fun incrementCounter(currentCounter: Int) = currentCounter + 1
    fun resetCounter() = 0
    fun decrementCounter(currentCounter: Int): Int {
        return if (currentCounter == 0)
            0
        else
            currentCounter - 1
    }
}