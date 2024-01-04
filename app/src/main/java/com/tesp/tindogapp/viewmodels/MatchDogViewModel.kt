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


class MatchDogViewModel() : ViewModel() {
    var Loading: Boolean by mutableStateOf(false)
    var Dog: Dog? by mutableStateOf(null)
    var MatchDog: Dog? by mutableStateOf(null)

    fun SetContext(mainViewModel: MainViewModel, dogId: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            // Get My Dog Details
            try {
                Loading = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getDog( mainViewModel.AuthToken, dogId).execute();
                }

                Dog = response.body()?: Dog(Id = 1,
                    Nome = "Bob",
                    Idade = 3,
                    Descricao = "Cão Muito Meigo",
                    Localidade = "Carregado",
                    Imagem = null,
                    Raca = "Golden Retriever",
                    Chip = false,
                    Sexo = "Masculino",
                    Vacinas = null)

                Loading = false;
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }

            // Get My Dog Match Details
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.getDogMatch(mainViewModel.AuthToken, dogId).execute();
                }

                MatchDog = response.body()?: Dog(Id = 1,
                    Nome = "Bob",
                    Idade = 3,
                    Descricao = "Cão Muito Meigo",
                    Localidade = "Carregado",
                    Imagem = null,
                    Raca = "Golden Retriever",
                    Chip = false,
                    Sexo = "Masculino",
                    Vacinas = null);
            }
            catch (e:Exception)
            {

            }
            Loading = false;
        }
    }
}