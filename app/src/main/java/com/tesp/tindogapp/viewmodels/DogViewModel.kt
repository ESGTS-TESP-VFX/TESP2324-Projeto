package com.tesp.tindogapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.tesp.tindogapp.model.Dog

class DogViewModel: ViewModel() {
    fun DoSaveDog(navController: NavHostController) {
        navController.navigate("match")
    }

    var Dog: Dog = Dog(0, "", 0, "","",0,"","")
}