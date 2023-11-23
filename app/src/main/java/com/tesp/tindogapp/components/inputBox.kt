package com.tesp.tindogapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun InputEmailComponent(): Boolean {
    var valid= false
    inputBox("Email", isValid = { valid }){
        valid= !it.isNullOrEmpty() && it.contains("@") && it.contains(".com")
    }
    return valid;
}
@Composable
@Preview()
fun InputUsernameComponent():Boolean{
    var valid= false
    inputBox("Username", isValid = { valid }){
        valid= !it.isNullOrEmpty() && it.length > 5
    }
    return valid;
}
@Composable
@Preview()
fun InputConfirmPasswordComponent():Boolean{
    var valid= false
    inputBox("Confirmar Password", visualTransformation = PasswordVisualTransformation(), isValid = { valid }){
        valid = !it.isNullOrEmpty()
    }
    return valid;
}
@Composable
@Preview()
fun InputPasswordComponent():Boolean{
    var valid= false
    inputBox("Password", visualTransformation = PasswordVisualTransformation(), isValid = { valid }){
        valid = !it.isNullOrEmpty()
    }
    return valid;
}
@Composable
@Preview()
fun ExemploTexto(): Unit {

    var valid= false
    inputBox("Titulo Normal", isValid = { valid }){
        !it.isNullOrEmpty() && it.contains("@") && it.contains(".com")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview()
fun inputBox(titulo: String ="Titulo Default",
             visualTransformation: VisualTransformation = VisualTransformation.None,
             isValid: () -> Boolean = { true},
             onValueChange: (String) -> Unit = {}): Boolean {
    var value by remember { mutableStateOf("asd") }
    var isValid by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = {
            value = it
            isValid = isValid()
        },
        label = { Text(titulo) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(16.dp)),

        visualTransformation = visualTransformation
    )

    return isValid;
}