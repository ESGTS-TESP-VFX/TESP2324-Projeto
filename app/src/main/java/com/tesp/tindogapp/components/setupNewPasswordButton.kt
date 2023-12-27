package com.tesp.tindogapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//@Preview
@Composable

fun SetupNewPasswordButtonComponent(onClickSendNewPassword: () -> Unit) {

    Button(
        onClick = onClickSendNewPassword,
        colors = ButtonDefaults.buttonColors(Color(0xFFFF8769)),
        modifier = Modifier
            .padding(6.dp)
            .width(200.dp)
    ) {
        Text(text = "OK")
    }
}

