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


class SignUpViewModel : ViewModel() {
    var Email: String = "";
    var Password: String = "";
    var ConfirmPassword: String = "";

    var SignUpSuccessfull: Boolean by mutableStateOf(false)
    var DoingSignUp: Boolean by mutableStateOf(false)

    fun DoSignUpRealThing(mainViewModel: MainViewModel, navController: NavController) {
        viewModelScope.launch {
            DoingSignUp = true;
            // validar se necessário para escrever novo utilizador
            // validar se serve de teste de acesso à bd
            val apiService = ApiService.getInstance();
            try {
                //em principio não faz sentido pois ainda não existe o user
                var body = withContext(Dispatchers.IO) {
                    apiService.getToken(TokenRequest(Email, Password)).execute()
                }
                

                if (body.raw().code == 200) {
                    navController.navigate("pickDog")
                    mainViewModel.AuthToken = body.body()?.token ?: "";
                    SignUpSuccessfull = true;
                } else {
                    Password = "";
                    SignUpSuccessfull = false;
                }
            } catch (e: Exception) {
                Log.d("MYERROR", e.message.toString())
                SignUpSuccessfull = false;
            }
            DoingSignUp = false;
        }
    }


    fun isEmailValid(): Boolean {
        return com.tesp.tindogapp.utils.isEmailValid(this.Email)
    }

    fun isPasswordValid(): Boolean {
        return com.tesp.tindogapp.utils.isPasswordValid(this.Password)
    }

    fun isConfirmPasswordValid(): Boolean {
        return com.tesp.tindogapp.utils.isPasswordValid(this.ConfirmPassword)
    }
//////////////////////////////////////////////////////////////


    fun isAnswerValid(): Boolean {
        return (isEmailValid() && isPasswordValid() && isConfirmPasswordValid() && this.Password == this.ConfirmPassword)

    }

}


/*
fun IsValidCredentials(): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    var emailValid = this.Email.matches(emailRegex.toRegex())
    var passwordValid = this.Password.length>5;

    return passwordValid && emailValid;
}


fun DoSignUp(mainViewModel: MainViewModel, navController: NavController) {
    navController.navigate("signPage")
}

 */

