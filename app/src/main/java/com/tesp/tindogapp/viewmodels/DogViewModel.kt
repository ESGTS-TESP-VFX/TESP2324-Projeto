package com.tesp.tindogapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.tesp.tindogapp.model.Dog2

class DogViewModel: ViewModel() {
    fun DoSaveDog(navController: NavHostController) {
        // Chamada à API
        //.... Dog = ChamadaAPI
        navController.navigate("match/${Dog.Id}")
    }

    var Dog: Dog2 = Dog2(0, "", null, "","",0,"","")
}