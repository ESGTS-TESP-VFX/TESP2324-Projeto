package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Dog2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DogPageViewModel : ViewModel() {

    var LoadingDogProfile: Boolean by mutableStateOf(false)
    var Dog2: Dog2? by mutableStateOf(Dog2(1,
        "Bockey",
        null,
        "Cão Muito Meigo",
        "Benavente",
        5,
        Raca = "Pastor Alemão",
        "Masculino", Chip = true))

    fun SetContext(mainViewModel: MainViewModel, dog2ID: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingDogProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getDog2( mainViewModel.AuthToken, dog2ID).execute();
                }

                Dog2 = response.body()?: Dog2(0,"", null, "","",0,"","");
                LoadingDogProfile = false;
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }


            LoadingDogProfile = false;
        }
    }


}
