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


class DogPageViewModel : ViewModel() {

    var LoadingDogProfile: Boolean by mutableStateOf(false)
    var Dog2: Dog? by mutableStateOf(Dog(1,
        "Bockey",
        0,
        "Cão Muito Meigo",
        "Benavente",
        null,
        "Pastor Alemão",
        "Masculino",
        true,
        null))

    fun SetContext(mainViewModel: MainViewModel, dog2ID: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingDogProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getDog( mainViewModel.AuthToken, dog2ID ).execute();
                }

                Dog2 = response.body()?:    Dog(Id = 2, Nome = "Buddy", Idade = 3, Descricao = "Cão Muito Meigo", Localidade = "VFX",
                    Imagem = null,
                    Chip = false,
                    Sexo = "Masculino",
                    Vacinas = null,
                    Raca = "Labrador");
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
