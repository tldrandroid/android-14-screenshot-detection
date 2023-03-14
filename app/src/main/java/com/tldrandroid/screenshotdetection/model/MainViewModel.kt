package com.tldrandroid.screenshotdetection.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val viewModelState = MutableStateFlow(MainUiState())
    val uiState = viewModelState
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            MainUiState()
        )

    init {
        defaultValue()
    }

    fun defaultValue() {
        viewModelState.update {
            it.copy(message = "Hello World!")
        }
    }

    fun screenshotValue() {
        viewModelState.update {
            it.copy(message = "Hey, I saw that!")
        }
    }
}

data class MainUiState(
    val message: String = ""
)