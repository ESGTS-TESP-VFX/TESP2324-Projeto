package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.apiService.UpdateProfileRequest
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogViewModel: ViewModel() {
    fun DoSaveDog(mainViewModel: MainViewModel, navController: NavHostController) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();
            try {
                //em principio não faz sentido pois ainda não existe o user
                var body = withContext(Dispatchers.IO) {
                    apiService.createDog(mainViewModel.AuthToken, Dog).execute()
                }

                if (body.raw().code == 200) {
                    Dog = Dog(
                        Id= body.body()?.Id?:0,
                        Nome =body.body()?.Nome?:"",
                        Idade=body.body()?.Idade?:0,
                        Descricao = body.body()?.Descricao?:"",
                        Raca = body.body()?.Raca?:"",
                        Sexo = body.body()?.Sexo?:"",
                        Chip = body.body()?.Chip?:false,
                        Imagem = body.body()?.Imagem?:"",
                        Localidade  = body.body()?.Localidade?:"",
                        Vacinas = body.body()?.Vacinas?: listOf())
                    ;

                    navController.navigate("match/${Dog.Id}")
                }
                else {
                    Log.d("MYERROR", body.raw().code?.toString()?:"AKI")
                }
            } catch (e: Exception) {
                Log.d("MYERROR", e.message.toString())
            }
        }
    }

    var Dog: Dog = Dog(1,
        "Bockey",
        0,
        "Cão Muito Meigo",
        "Benavente",
        "",
        "Pastor Alemão",
        "Masculino",
        true,
        listOf())
}