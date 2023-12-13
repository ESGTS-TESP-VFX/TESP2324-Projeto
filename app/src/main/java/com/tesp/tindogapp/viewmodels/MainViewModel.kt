package com.tesp.tindogapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var AuthToken by mutableStateOf("BLA")
}