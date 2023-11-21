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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tesp.tindogapp.R

@Preview
@Composable
fun CaixaInputs() {
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
            Text(
                text = R.string.loginText.toString(),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            InputEmailComponent()
            InputPasswordComponent()


            SignInButtonComponent()

            //este texto só aparece quando os dados de login forem inválidos
            Text(
                text = R.string.invalid_login_data.toString(),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = Color(0xFFFF0000),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Text(
                text = R.string.reset_password_link.toString(),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = Color(0xFFFF0000),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )


            Text(
                text = R.string.create_account_message.toString(),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            SignUpButtonComponent()
        }
    }
}
