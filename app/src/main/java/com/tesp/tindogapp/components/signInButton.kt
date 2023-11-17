package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.wallet.button.ButtonConstants
import com.tesp.tindogapp.R

@Preview
@Composable

fun SignInButtonComponent() {

    Button(
        onClick = {
            /* Handle login logic here */
        },
        colors = ButtonDefaults.buttonColors(Color(0xFFFF8769)),
        modifier = Modifier
            //.fillMaxWidth()
            .padding(8.dp)
            .width(200.dp)
    ) {
        Text(text = "Sign in")
    }
}