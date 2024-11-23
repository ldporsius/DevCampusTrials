package nl.codingwithlinda.testversionscatalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel: ViewModel() {

    private var _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    //this causes weird behaviour
    fun startCounter() = viewModelScope.launch {
        _count.value = 0
        while (true){
            _count.getAndUpdate {
                it.plus(1)
            }
            delay(1000)

        }
    }

    private var counterJob: Job? = null

    //this seems to behave better
    fun startCounterNewJob() {
        counterJob?.cancel()
        counterJob = viewModelScope.launch {
            _count.value = 0
            while (true) {
                delay(1000)

                _count.update {
                    it.plus(1)
                }

            }
        }
    }

    fun stopCounter() {
        counterJob?.cancel()
        _count.value = 0

    }
}