package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tesp.tindogapp.viewmodels.LoginViewModel
import com.tesp.tindogapp.viewmodels.MainViewModel

@Composable
@Preview()
fun LoginCorpo(
    navController: NavController = rememberNavController(),
    mainViewModel: MainViewModel = viewModel(),
    loginVm: LoginViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .background(Color(0xFFFFDBD2), shape = RoundedCornerShape(16.dp))
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.loginText),
                fontFamily = FontFamily.Monospace,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 5.dp)
            )
            loginVm.Email = InputEmailComponent()
            loginVm.Password = InputPasswordComponent()

            if (!loginVm.IsValidCredentials()) {
                Text(
                    text = stringResource(id = R.string.invalid_register_data),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }

            if (loginVm.DoingLogin) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = Color(0xFFBB3210)
                )
                Spacer(modifier = Modifier.height(64.dp))
            }
            else{
                SignInButtonComponent{
                    loginVm.DoLogin(mainViewModel,navController)
                }
            }


            Text(
                // texto só deverá aparecer quando se carrega no botão
                text = stringResource(R.string.reset_password_link),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFF000000),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clickable {
                        loginVm.DoPwdReset(navController)
                    }
                    // ligação ao reset password
            )


            Text(
                text = stringResource(R.string.create_account_message),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clickable { }
            )

            SignUpButtonComponent(){
                loginVm.DoSignUp(mainViewModel,navController)
            }
        }
    }
}
