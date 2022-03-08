package com.robybp.hearthstonehelper.core.viewstate

sealed class Async<out T> {

    object Uninitialized : Async<Nothing>()

    object Loading : Async<Nothing>()

    data class Success<out T>(val value: T) : Async<T>()

    data class Fail<out T>(val error: Throwable) : Async<T>()
}
