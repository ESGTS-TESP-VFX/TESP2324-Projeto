package com.tesp.tindogapp.pages
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.components.ResetPasswordBody
import com.tesp.tindogapp.viewmodels.MainViewModel
import com.tesp.tindogapp.viewmodels.recoverPwPageViewModel


@Preview(showBackground = true, heightDp = 700, widthDp = 380)
@Composable
fun ResetPasswordPage(navController: NavHostController = rememberNavController(),
                      viewModel: MainViewModel = MainViewModel(),
                      recoverVm: recoverPwPageViewModel = recoverPwPageViewModel()) : Unit {
    Box(
        modifier = Modifier
            .padding(0.dp) // Set the margins here
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Logotipo()
            ResetPasswordBody(navController, viewModel, recoverVm)
        }
    }
}
//