package com.tesp.tindogapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tesp.tindogapp.model.Owner

class MainViewModel: ViewModel() {
    var Owner: Owner = Owner(0, "", "", "","")
    var AuthToken by mutableStateOf("")
}