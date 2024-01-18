package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

class OwnerEditViewModel: ViewModel() {
    var Nome: String by mutableStateOf("")
    var Descricao: String by mutableStateOf("")
    var Id: Int by mutableStateOf(0)
    var Image: String by mutableStateOf("")
    var Dogs: List<Dog> by mutableStateOf(listOf())
    var Loaded: Boolean by mutableStateOf(false)

    fun SetContext(mainViewModel: MainViewModel) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.getProfile(mainViewModel.AuthToken).execute();
                }

                val dogs = withContext(Dispatchers.IO) {
                    apiService.getDogs(mainViewModel.AuthToken).execute();
                }

                Dogs = dogs.body()?: listOf<Dog>();
                var owner = response.body()!!;

                Nome = owner.Nome;
                Id = owner.Id;
                Image = owner.Image;
                Descricao = owner.Descricao;

                Loaded = true;
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }
        }
    }
    fun DoSaveOwner(mainViewModel: MainViewModel, navController: NavHostController) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.updateProfile(mainViewModel.AuthToken,
                        UpdateProfileRequest(
                            Nome,
                            Image,
                            Descricao
                        )
                    ).execute();
                }

                var owner = response.body()!!;
                Nome = owner.Nome;
                Id = owner.Id;
                Image = owner.Image;
                Descricao = owner.Descricao;
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }
        }

        navController.navigate("SeeOwnerPage/${Id}")
    }
}