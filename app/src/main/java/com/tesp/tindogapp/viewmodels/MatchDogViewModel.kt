package com.tesp.tindogapp.viewmodels

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

class MatchDogViewModel: ViewModel() {
    var Loading: Boolean by mutableStateOf(false)
    var Dog: Dog? by mutableStateOf(null)
    var MatchDog: Dog? by mutableStateOf(null)
    fun SetContext(mainViewModel: MainViewModel, id: Int) {
        viewModelScope.launch {
            Loading = true;
            val apiService = ApiService.getInstance();

            // Get My Dog Details
            try {
                val dog = withContext(Dispatchers.IO) {
                    apiService.getDog().execute().body();
                }

                Dog = dog;
            }
            catch (e:Exception)
            {

            }

            // Get My Dog Match Details
            try {
                val dog = withContext(Dispatchers.IO) {
                    apiService.getDogMatch().execute().body();
                }

                MatchDog = dog;
            }
            catch (e:Exception)
            {

            }
        }

        Loading = false;
    }

}