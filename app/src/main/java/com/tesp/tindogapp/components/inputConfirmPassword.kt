package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable

fun InputConfirmPasswordComponent(): Pair<String, Boolean> {
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var isvalidB by remember { mutableStateOf(false) }

    TextField(
        value = confirmPassword,
        onValueChange = {
            confirmPassword = it
            isvalidB= !it.isNullOrEmpty() //&& it == password
        },
        label = {
            Text("Confirm Password")
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8. dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        visualTransformation = PasswordVisualTransformation()
    )
    return  confirmPassword to isvalidB;
}
//
