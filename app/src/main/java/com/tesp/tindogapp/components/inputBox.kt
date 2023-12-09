package com.tesp.tindogapp.components


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tesp.tindogapp.utils.isUsernameValid
import com.tesp.tindogapp.utils.isEmailValid
import com.tesp.tindogapp.utils.isPasswordValid


@Composable
@Preview()
fun InputUsernameComponent():String{
    var valid= false
    return inputBox("Username", isValidCall = { valid }){
        valid= isUsernameValid(it)
    }
}
@Composable
@Preview
fun InputEmailComponent(): String {
    var valid = false
    return  inputBox("Email", isValidCall = { valid }){
        valid= isEmailValid(it)
    }
}
@Composable
@Preview()
fun InputPasswordComponent():String{
    var valid= false
    return inputBox("Password", visualTransformation = PasswordVisualTransformation(), isValidCall = { valid }){
        valid= isPasswordValid(it)
    }
}
@Composable
@Preview()
fun InputConfirmPasswordComponent():String{
    var valid= false
    return inputBox("Confirm Password", visualTransformation = PasswordVisualTransformation(), isValidCall = { valid }){
        valid= isPasswordValid(it)
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

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun InputCodeComponent(titulo: String = "default",
        onValueChange:(String)-> Unit={}): String {
    var valueX by remember {mutableStateOf("")}
    TextField(
        value =  valueX,
        onValueChange = {
            valueX = it
        },
        label = { Text(titulo) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),
        Alignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(50.dp)
            .width(50.dp)
            .clip(CircleShape),
        //visualTransformation = visualTransformation
        )
    return valueX;

}

 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun InputCodeDigit(titulo: String = "0",
                       onValueChange:(String)-> Unit={}): String {
    var value by remember {mutableStateOf("")}
    TextField(
        value =  value,
        onValueChange = {
            value = it
        },
        label = { Text(titulo) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),

        modifier = Modifier
            .height(50.dp)
            .width(50.dp)
            .clip(CircleShape)
            .fillMaxSize(),
        //textAlign = TextAlign.Center
        //visualTransformation = visualTransformation
    )
    return value;
}

@Composable
@Preview()
fun InputCodeComponent():String{

    return InputCodeDigit()
    }

//.padding(16.dp)
// Add padding for better appearance
// .align(Alignment.CenterHorizontally)

