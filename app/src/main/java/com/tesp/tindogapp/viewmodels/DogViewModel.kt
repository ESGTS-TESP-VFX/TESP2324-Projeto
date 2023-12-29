package com.tesp.tindogapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Dog2

class DogViewModel: ViewModel() {
    fun DoSaveDog(navController: NavHostController) {
        navController.navigate("match/0")
    }

    var Dog2: Dog2 = Dog2(0, "", null, "","",null,"","")
}