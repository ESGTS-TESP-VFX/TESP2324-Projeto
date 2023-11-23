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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.wallet.button.ButtonConstants
import com.tesp.tindogapp.R

@Preview
@Composable
fun SignUpButtonComponent(onClickSigin: () -> Unit ={}) {

    Button(
        onClick = onClickSigin,
        colors = ButtonDefaults.buttonColors(
            Color(0xFFFFFFFF),
            contentColor = Color(0xFF000000)),
        modifier = Modifier
            //.fillMaxWidth()
            .padding(6.dp)
            .width(200.dp)

    ) {
        Text(text = "Sign Up")

    }
}
//