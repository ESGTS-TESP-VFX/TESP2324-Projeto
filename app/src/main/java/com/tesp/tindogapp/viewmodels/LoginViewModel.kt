package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.tesp.tindogapp.apiService.ApiService
import com.tesp.tindogapp.apiService.TokenRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel:ViewModel() {
    var Email: String ="";
    var Password: String="";

    var LoginSuccessfull: Boolean by mutableStateOf(false)
    var DoingLogin: Boolean by mutableStateOf(false)

    fun DoLogin(mainViewModel: MainViewModel, navController: NavController) {
        viewModelScope.launch {
            DoingLogin = true;
            val apiService = ApiService.getInstance();
            try {
                var body =  withContext(Dispatchers.IO) {
                    apiService.getToken(TokenRequest(Email, Password)).execute()
                }

                if (body.raw().code == 200 )
                {
                    navController.navigate("pickDog")
                    mainViewModel.AuthToken = body.body()?.token ?:"";
                    LoginSuccessfull = true;
                }
                else
                {
                    Password = "";
                    LoginSuccessfull = false;
                }
            }
            catch (e:Exception)
            {
                Log.d("MYERROR", e.message.toString())
                LoginSuccessfull = false;
            }
            DoingLogin = false;
        }
    }

    fun IsValidCredentials(): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        var emailValid = this.Email.matches(emailRegex.toRegex())
        var passwordValid = this.Password.length>5;

        return passwordValid && emailValid;
    }

    fun DoSignUp(mainViewModel: MainViewModel, navController: NavController) {
        navController.navigate("signPage")
    }

}