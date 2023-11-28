package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VarInputLocBox() {
    var inputLoc by remember { mutableStateOf("") }


    Text(
        text = "What's your Dog Location?",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 8.dp)
    )


    OutlinedTextField(
        value = inputLoc,
        onValueChange = { inputLoc = it },
        label = {
            Text(
                "Insert your location...",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = Color(0xFFBF8B7E)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 30.dp, 0.dp, 0.dp)
            .background(Color.White, CircleShape),


        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        )
    )
}