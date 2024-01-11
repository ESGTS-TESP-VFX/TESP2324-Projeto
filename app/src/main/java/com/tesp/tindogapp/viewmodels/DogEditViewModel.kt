package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogEditViewModel: ViewModel() {
    fun DoSaveDog(navController: NavHostController) {
        // Chamada à API
        //.... Dog = ChamadaAPI
        navController.navigate("SeeDogPage/${Dog.Id}")
    }

    var LoadingDogProfile: Boolean by mutableStateOf(false)
    var Dog: Dog = Dog(
        1,
        "Bockey",
        0,
        "Cão Muito Meigo",
        "Benavente",
        null,
        "Pastor Alemão",
        "Masculino",
        true,
        null
    )

    fun SetContext(mainViewModel: MainViewModel, dog2ID: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingDogProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getDog(mainViewModel.AuthToken, dog2ID).execute();
                }

                Dog = response.body() ?: Dog(
                    Id = 2,
                    Nome = "Buddy",
                    Idade = 3,
                    Descricao = "Cão Muito Meigo",
                    Localidade = "VFX",
                    Imagem = null,
                    Chip = false,
                    Sexo = "Masculino",
                    Vacinas = null,
                    Raca = "Labrador"
                )

            }catch(e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }


            LoadingDogProfile = false;
        }
    }
}
