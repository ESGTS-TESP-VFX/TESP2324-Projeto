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
    var Dog2: Dog2? by mutableStateOf(null)

    fun SetContext(mainViewModel: MainViewModel, dog2ID: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingOwnerProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getOwner( mainViewModel.AuthToken, ownerId).execute();
                }

                Owner = response.body()?: Owner(0,"", null, "");
                LoadingOwnerProfile = false;
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
            }


            LoadingOwnerProfile = false;
        }
    }


}
