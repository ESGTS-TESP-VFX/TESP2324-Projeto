package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.utils.checkData
import com.tesp.tindogapp.utils.isEmailValid
import com.tesp.tindogapp.utils.isPasswordValid

@Composable
@Preview
fun SignUpBody(navController: NavController = rememberNavController()) {
    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var validAnswer by remember {
                mutableStateOf(true)
            }
            Text(
                text = stringResource(id = R.string.register),
                fontFamily = FontFamily.Monospace,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 5.dp)
            )
/*
            var username = InputUsernameComponent()
            if (!isUsernameValid(username)) {
                Text(
                    text = stringResource(id = R.string.imput_invalid_username),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }

 */
            var email = InputEmailComponent()
            if (!isEmailValid(email)) {
                Text(
                    text = stringResource(id = R.string.input_invalid_email),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
            var password = InputPasswordComponent()
            if (!isPasswordValid(password)) {
                Text(
                    text = stringResource(id = R.string.input_invalid_password),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
            var confirmPassword = InputConfirmPasswordComponent()
            if (!isPasswordValid(confirmPassword)) {
                Text(
                    text = stringResource(id = R.string.input_invalid_password),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
            validAnswer = checkData(email, password, confirmPassword);

            if (!validAnswer) {
                //este texto só aparece quando os dados de login forem inválidos
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

            SubmitButtonComponent() {
                navController.navigate("formOwnerPage")
            }
        }
    }
}
//