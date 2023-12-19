package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KennelViewModel: ViewModel() {
    fun SetContext(mainViewModel: MainViewModel) {
        viewModelScope.launch {
            Loading = true;
            val apiService = ApiService.getInstance();
            var token = mainViewModel.AuthToken;
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.getDogs(token).execute();
                }

                Dogs = response.body()?: listOf<Dog>();
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
                Dogs = listOf<Dog>()
            }
        }

        Loading = false;
    }

    var Loading: Boolean by mutableStateOf(false)
    var Dogs: List<Dog> by mutableStateOf(listOf<Dog>())
}
