package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.model.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerEditViewModel: ViewModel() {
    fun DoSaveOwner(navController: NavHostController) {
        // Chamada à API
        //.... Owner = ChamadaAPI
        navController.navigate("SeeOwnerPage/${Owner.Id}")
    }

    var LoadingOwnerProfile: Boolean by mutableStateOf(false)
    var Owner: Owner = Owner(
        1,
        "José",
        null,
        "ola",
    )

    fun SetContext(mainViewModel: MainViewModel, owner2ID: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingOwnerProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getOwner(mainViewModel.AuthToken, owner2ID).execute();
                }

                Owner = response.body() ?: Owner(
                    Id = 2,
                    Nome = "Manel",
                    Image = null,
                    Desc = "ola"
                )

            }catch(e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }


            LoadingOwnerProfile = false;
        }
    }
}