package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.apiService.SignUpRequest
import com.tesp.tindogapp.apiService.UpdateProfileRequest
import com.tesp.tindogapp.model.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class OwnerViewModel: ViewModel() {
    fun DoSaveOwner(mainViewModel: MainViewModel, navController: NavHostController) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();
            try {
                //em principio não faz sentido pois ainda não existe o user
                var body = withContext(Dispatchers.IO) {
                    apiService.updateProfile(mainViewModel.AuthToken, UpdateProfileRequest(
                        Owner.Nome,
                        Owner.Image,
                        Owner.Descricao
                    )).execute()
                }

                if (body.raw().code == 200) {
                    navController.navigate("formDogPage")
                    mainViewModel.Owner = body.body()!!;
                }
            } catch (e: Exception) {
                Log.d("MYERROR", e.message.toString())
            }
        }
    }


    var Owner: Owner= Owner(0, "", "", "","")
}

