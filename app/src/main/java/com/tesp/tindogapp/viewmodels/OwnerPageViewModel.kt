package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class OwnerPageViewModel : ViewModel() {

    var LoadingOwnerProfile: Boolean by mutableStateOf(false)
    var Owner: Owner? by mutableStateOf(Owner(1,
        "José",
        "null",
        "adeus",
        "jose@gmail.com"))

    fun SetContext(mainViewModel: MainViewModel, ownerId: Int) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance();

            try {
                LoadingOwnerProfile = true;
                val response = withContext(Dispatchers.IO) {
                    apiService.getOwner( mainViewModel.AuthToken, ownerId).execute();
                }

                Owner = response.body()?: Owner(2,"Manel", "null","adeus", "manel@gmail.com");
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

