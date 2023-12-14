package com.tesp.tindogapp.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.LoginCorpo
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.viewmodels.LoginViewModel
import com.tesp.tindogapp.viewmodels.MainViewModel

@Preview(showBackground = true, heightDp = 700, widthDp = 380)
@Composable
fun LoginPage(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = MainViewModel(),
    loginVm: LoginViewModel = LoginViewModel()
): Unit {
    Box(
        modifier = Modifier
            .padding(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Logotipo()
            LoginCorpo(navController,viewModel, loginVm)
        }
    }
}