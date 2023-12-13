package com.tesp.tindogapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executor

class LoginViewModel:ViewModel() {
    var Email: String ="";
    var Password: String="";

    fun DoLogin(): String {
        /*
        val client = OkHttpClient()

        Executor executor = Executors.new

        val request = Request.Builder()
            .url("https://ac1f38b9-e49a-4f67-a964-c22a73af60de.mock.pstmn.io/api/token")
            .addHeader("Content-Type", "application/json")
            .build()
        val response = client.newCall(request).execute()

        Log.d("TAG", response.message)
*/
        return  "asdq";
    }

    fun IsValidCredentials(): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        var emailValid = this.Email.matches(emailRegex.toRegex())
        var passwordValid = this.Password.length>5;

        return passwordValid && emailValid;
    }
}