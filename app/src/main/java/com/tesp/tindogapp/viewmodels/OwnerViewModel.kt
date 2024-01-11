package com.tesp.tindogapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.tesp.tindogapp.model.Owner


class OwnerViewModel: ViewModel() {
    fun DoSaveOwner(navController: NavHostController) {
        navController.navigate("formDogPage")
    }


    var Owner: Owner= Owner(0, "", "", "","")
}

