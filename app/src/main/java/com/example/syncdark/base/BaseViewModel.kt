package com.example.syncdark.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.syncdark.utils.SingleLiveEvent

abstract class BaseViewModel<Intent, State> : ViewModel() {

    protected val _state = SingleLiveEvent<State>()
    val state: LiveData<State> = _state

    abstract fun handle(intent: Intent)
}