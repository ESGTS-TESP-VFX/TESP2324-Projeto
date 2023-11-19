package com.tesp.tindogapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.Logotipo

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, heightDp = 780, widthDp = 380)
@Composable
fun DogFormPage(navController: NavHostController = rememberNavController()): Unit {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Logotipo()
        ContainerInputs()
    }
}


@Composable
fun ContainerInputs() {
    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InputDogNameAge()
            NextButton()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDogNameAge() {
    var inputName by remember { mutableStateOf("") }
    var inputAge by remember { mutableStateOf("") }

    // Input DogName
    Text(
        text = "What's your Dog's Name?",
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )

    // Input DogName
    OutlinedTextField(
        value = inputName,
        onValueChange = { inputName = it },
        label = { Text("Insert here dog's name...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        )
    )

    // Input DogAge
    Text(
        text = "What's your Dog's Age?",
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )

    // Input DogAge
    OutlinedTextField(
        value = inputAge,
        onValueChange = { inputAge = it },
        label = { Text("Insert here dog's age...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        )
    )
}

@Composable
fun NextButton() {

    val onNextClick: () -> Unit = {
        var inputName = ""
        var inputAge = ""
        println("Dog's Name: $inputName, Dog's Age: $inputAge")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        androidx.compose.material3.Button(
            onClick = onNextClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
            //.background(Color(0xFFFF8769))
        ) {
            Text(
                text = "Next",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}



