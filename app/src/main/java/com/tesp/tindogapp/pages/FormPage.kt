package com.tesp.tindogapp.pages

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.components.VarInputBreedSexDog
import com.tesp.tindogapp.components.VarInputDescBox
import com.tesp.tindogapp.components.VarInputLocBox
import com.tesp.tindogapp.components.VarInputNameAgeBox

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun FormPage(navController: NavHostController = rememberNavController()) {
    var currentStep by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentStep) {
            1 -> Step1(onNext = { currentStep = 2 })
            2 -> Step2(onBack = { currentStep = 1 }, onNext = { currentStep = 3 })
            3 -> Step3(onBack = { currentStep = 2 }, onNext = { currentStep = 4 })
            4 -> Step4(onBack = { currentStep = 3 }, onNext = { currentStep = 5 })
            5 -> Step5(onBack = { currentStep = 6 }, onNext = { currentStep = 6 })
            6 -> Step6(onBack = { currentStep = 1 }, onNext = { currentStep = 10 })
            //7 -> Step7(onBack = { currentStep = 1 })
        }
    }
}

/* FORM PARA TELA COM APENAS 1 PERGUNTA E RESPOSTA
@Composable
fun Step1(onNext: () -> Unit) {
    Column {
        Logotipo()
        InputOwnerNameBox(onNext = onNext)
    }
}
*/

// FORM PARA NOME E IDADE DO CAO
@Composable
fun Step1(onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDogNameBox(onNext = onNext)
    }
}

// FORM PARA DESCRICAO
@Composable
fun Step2(onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDescBox(onBack = onBack, onNext = onNext)
    }
}
// FORM PARA RAÇA E SEXO DO CAO
@Composable
fun Step3(onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputBreedSexBox(onBack = onBack,onNext = onNext)
    }
}
// FORM PARA LOCALIZACAO DO CAO
@Composable
fun Step4(onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputLocBox(onBack = onBack,onNext = onNext)
    }
}
// FROM PARA CHIP DO CAO
@Composable
fun Step5(onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputChipBox(onBack = onBack,onNext = onNext)
    }
}
//FORM PARA FINISH OU NAO DO CAO
@Composable
fun Step6(onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputFinishBox(onBack = onBack,onNext = onNext)
    }
}

@Composable
fun Step7(onNext: () -> Unit) {
    Column {
        Logotipo()
    }
}

// STEP-1 VAR INPUTS NOME E IDADE DO CAO
@Composable
fun InputDogNameBox(onNext:() -> Unit) {
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

            VarInputNameAgeBox()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = onNext,
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
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
            }

        }
    }
}

// STEP-2 VAR INPUTS DE DESCRIPTION
@Composable
fun InputDescBox(onBack: () -> Unit, onNext: () -> Unit) {
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

            VarInputDescBox("Dog Description")

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


// STEP-3 VAR INPUTS RACA E SEXO DO CAO
@Composable
fun InputBreedSexBox(onBack: () -> Unit,onNext:() -> Unit) {
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

            VarInputBreedSexDog()

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


// VAR INPUTS DE LOCALIZACAO DO CAO
@Composable
fun InputLocBox(onBack: () -> Unit,onNext:() -> Unit) {
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

            VarInputLocBox()

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

// VAR INPUTS DE CHIP OU NAO DO CAO
@Composable
fun InputChipBox(onBack: () -> Unit,onNext:() -> Unit) {
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
                text = "Does your dog have a microchip?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
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
                    Text(text = "No",
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
                    Text(text = "Yes",
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

// VAR INPUTS DE FINISH OU NAO DO CAO
@Composable
fun InputFinishBox(onBack: () -> Unit,onNext:() -> Unit) {
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
                text = "Are you finished?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
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
                    Text(text = "No",
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
                    Text(text = "Finished",
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
