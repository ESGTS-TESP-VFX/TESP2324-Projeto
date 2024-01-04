package com.tesp.tindogapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.tesp.tindogapp.model.Dog

class DogViewModel: ViewModel() {
    fun DoSaveDog(navController: NavHostController) {
        // Chamada à API
        //.... Dog = ChamadaAPI
        navController.navigate("match/${Dog.Id}")
    }

    var Dog: Dog = Dog(1,
        "Bockey",
        0,
        "Cão Muito Meigo",
        "Benavente",
        null,
        "Pastor Alemão",
        "Masculino",
        true,
        null)
}