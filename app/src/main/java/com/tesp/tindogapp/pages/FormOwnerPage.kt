package com.tesp.tindogapp.pages

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.Logotipo
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.tesp.tindogapp.R
import com.tesp.tindogapp.viewmodels.MainViewModel
import com.tesp.tindogapp.viewmodels.OwnerViewModel

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun FormOwnerPage(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = MainViewModel(),
    ownerViewModel: OwnerViewModel = OwnerViewModel()
) {

    var currentStep by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentStep) {
            1 -> Step1_Owner(ownerViewModel, onNext = { currentStep = 2 })
            2 -> Step2_Owner(ownerViewModel, onBack = { currentStep = 1 }) { currentStep = 3 }
            3 -> Step3_Owner(ownerViewModel, onBack = { currentStep = 2 })
            {
                currentStep = 4

                ownerViewModel.DoSaveOwner(navController)
            }
        }
    }
}


@Composable
fun Step1_Owner(ownerViewModel: OwnerViewModel = OwnerViewModel(), onNext: () -> Unit) {
    Column {
        Logotipo()
        InputOwnerNameBox(ownerViewModel, onNext = onNext)
    }
}

@Composable
fun Step2_Owner(ownerViewModel: OwnerViewModel, onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        PhotoPickerOwner(ownerViewModel, onBack = onBack, onNext = onNext)

    }
}


@Composable
fun Step3_Owner(ownerViewModel: OwnerViewModel, onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDescBox_Owner(ownerViewModel,onBack = onBack, onNext = onNext)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputOwnerNameBox(ownerViewModel: OwnerViewModel = OwnerViewModel(),onNext: () -> Unit) {

    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var inputName by remember { mutableStateOf(    ownerViewModel.Owner.Nome) }
            var isValid by remember { mutableStateOf(true) }

            Text(
                text = "What's your Name?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = inputName,
                onValueChange = {
                    inputName = it
                    isValid = it.isNotBlank()
                },
                label = {
                    Text(
                        "Insert your name...",
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

            if (!isValid) {
                Text(text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = {
                        ownerViewModel.Owner.Nome = inputName
                        if (isValid) {
                            onNext()
                        } else {
                            isValid = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8769)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Next",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDescBox_Owner(ownerViewModel: OwnerViewModel, onBack: () -> Unit, onNext: () -> Unit) {

    var inputDesc by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Tell us What do you Like?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = inputDesc,
                onValueChange = {inputDesc = it},
                label = {
                    Text(
                        "Insert a description...",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center,
                        color = Color(0xFFBF8B7E),
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .height(150.dp),


                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {


                Button(onClick = onBack,
                    modifier = Modifier

                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8769)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Back",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(onClick = onNext,
                    modifier = Modifier

                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8769)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Finish",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }

        }
    }
}


@Composable
fun PhotoPickerOwner(ownerViewModel: OwnerViewModel, onBack: () -> Unit, onNext: () -> Unit): Unit {
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            ownerViewModel.Owner.ImageUri = it
        }
    )

    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Show us how you look !",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Box (
                modifier = Modifier
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = "placehold",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.FillBounds
                )

                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    model = ownerViewModel.Owner.ImageUri,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            Button(onClick = {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            },
                modifier = Modifier
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBF8B7E)
                ),

                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Add Photo!",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {


                Button(onClick = onBack,
                    modifier = Modifier

                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8769)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Back",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(onClick = onNext,
                    modifier = Modifier
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8769)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Next",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }
        }

    }

}

