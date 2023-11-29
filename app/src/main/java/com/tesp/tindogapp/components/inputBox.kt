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
fun InputEmailComponent(): String {
    var valid = false
    return  inputBox("Email", isValidCall = { valid }){
        valid= !it.isNullOrEmpty() && it.contains("@") && it.contains(".com")
        //temos de validar a regra .com
    }
}
@Composable
@Preview()
fun InputUsernameComponent():String{
    var valid= false
    return inputBox("Username", isValidCall = { valid }){
        valid= !it.isNullOrEmpty() && it.length > 5
    }
}
@Composable
@Preview()
fun InputConfirmPasswordComponent():String{
    var valid= false
    return inputBox("Confirmar Password", visualTransformation = PasswordVisualTransformation(), isValidCall = { valid }){
        valid = !it.isNullOrEmpty()
    }
}
@Composable
@Preview()
fun InputPasswordComponent():String{
    var valid= false
    return inputBox("Password", visualTransformation = PasswordVisualTransformation(), isValidCall = { valid }){
        valid = !it.isNullOrEmpty()
    }
}
@Composable
@Preview()
fun ExemploTexto(): Unit {

    var valid= false
    inputBox("Titulo Normal", isValidCall = { valid }){
        !it.isNullOrEmpty() && it.contains("@") && it.contains(".com")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview()
fun inputBox(titulo: String ="Titulo Default",
             visualTransformation: VisualTransformation = VisualTransformation.None,
             isValidCall: () -> Boolean = { true},
             onValueChange: (String) -> Unit = {}): String {
    var value by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = {
            value = it
            isValid = isValidCall()
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

    return value;
}