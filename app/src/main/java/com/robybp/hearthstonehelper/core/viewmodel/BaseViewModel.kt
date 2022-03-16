package com.robybp.hearthstonehelper.core.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(this.javaClass.name, "An error occurred: $throwable")
    }

    private val bgScope = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)

    fun runInBackground(block: suspend () -> Unit) = bgScope.launch { block() }

    override fun onCleared() {
        bgScope.cancel()
        super.onCleared()
    }
}
