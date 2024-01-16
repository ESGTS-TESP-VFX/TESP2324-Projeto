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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.ui.theme.Orange
import com.tesp.tindogapp.ui.theme.OrangeOpacity65
import com.tesp.tindogapp.ui.theme.Salmon
import com.tesp.tindogapp.viewmodels.DogViewModel
import com.tesp.tindogapp.viewmodels.MainViewModel


@Preview(showBackground = true, heightDp = 700, widthDp = 380)
@Composable
fun FormDogPage(navController: NavHostController = rememberNavController(),
                mainViewModel: MainViewModel = MainViewModel(),
                dogViewModel: DogViewModel = DogViewModel()){

                var currentStep by remember { mutableStateOf(1) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentStep) {
            1 -> TelaNomeIdade(dogViewModel,onNext = { currentStep = 2 })
            2 -> TelaImagem(dogViewModel,onBack = { currentStep = 1 }, onNext = { currentStep = 3 })
            3 -> TelaDescricao(dogViewModel,onBack = { currentStep = 2 }, onNext = { currentStep = 4 })
            4 -> TelaRacaSexo(dogViewModel,onBack = { currentStep = 3 }, onNext = { currentStep = 5 })
            5 -> TelaLocalizacao(dogViewModel,onBack = { currentStep = 4 }, onNext = { currentStep = 6 })
            6 -> TelaChip(dogViewModel,onBack = {
                currentStep = 7
                dogViewModel.Dog.Chip = false
             }, onNext = {
                currentStep = 7
                dogViewModel.Dog.Chip = true
            })
            7 -> TelaFinish(dogViewModel,
                onBack = { currentStep = 1 },
                onNext = {
                    currentStep = 8
                    dogViewModel.DoSaveDog(mainViewModel,navController)
                })
        }
    }
}

//teste
// FORM PARA NOME E IDADE DO CAO
@Composable
fun TelaNomeIdade(dogViewModel: DogViewModel = DogViewModel(), onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDogNameBox(dogViewModel,onNext = onNext)
    }
}

// FORM PARA FOTO
@Composable
fun TelaImagem(dogViewModel: DogViewModel,onBack: () -> Unit, onNext: () -> Unit){
    Column {
        Logotipo()
        PhotoPickerDog(dogViewModel,onBack = onBack, onNext = onNext)
    }
}

// FORM PARA DESCRICAO
@Composable
fun TelaDescricao(dogViewModel: DogViewModel,onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDescBox(dogViewModel,onBack = onBack, onNext = onNext)
    }
}

// FORM PARA RAÇA E SEXO DO CAO
@Composable
fun TelaRacaSexo(dogViewModel: DogViewModel,onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputBreedSexBox(dogViewModel,onBack = onBack,onNext = onNext)
    }
}

// FORM PARA LOCALIZACAO DO CAO
@Composable
fun TelaLocalizacao(dogViewModel: DogViewModel,onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputLocBox(dogViewModel,onBack = onBack,onNext = onNext)
    }
}

// FROM PARA CHIP DO CAO
@Composable
fun TelaChip(dogViewModel: DogViewModel,onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputChipBox(dogViewModel,onBack = onBack,onNext = onNext)
    }
}

//FORM PARA FINISH OU NAO DO CAO
@Composable
fun TelaFinish(dogViewModel: DogViewModel,onBack: () -> Unit,onNext: () -> Unit) {
    Column {
        Logotipo()
        InputFinishBox(dogViewModel,onBack = onBack,onNext = onNext)
    }
}



// STEP-1 VAR INPUTS NOME E IDADE DO CAO
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDogNameBox(dogViewModel: DogViewModel = DogViewModel(),onNext:() -> Unit) {
    Box(
        modifier = Modifier
            .background(
                color = Salmon,
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
            var inputNameDog by remember { mutableStateOf(dogViewModel.Dog.Nome) }
            var inputAgeDog by remember { mutableStateOf(dogViewModel.Dog.Idade.toString()) }
            var isValidName by remember { mutableStateOf(true) }
            var isValidAge by remember { mutableStateOf(true) }

            // What's your Dog's Name?
            Text(
                text = "What's your Dog's Name?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Input DogName
            OutlinedTextField(
                value = inputNameDog,
                onValueChange = {
                    inputNameDog = it
                    dogViewModel.Dog.Nome = it
                },
                label = { Text("Insert here dog's name...",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    color = OrangeOpacity65,
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .background(Color.White, shape = CircleShape),


                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )
            if (!isValidName) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
            }

            // What's your Dog's Age?
            Text(
                text = "What's your Dog's Age?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Input DogAge
            OutlinedTextField(
                value = inputAgeDog,
                onValueChange = {
                    inputAgeDog = it
                    dogViewModel.Dog.Idade = it.toIntOrNull()?:0
                },
                label = { Text("Insert here dog's age...",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    color = OrangeOpacity65,
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .background(Color.White, shape = CircleShape),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )
            if (!isValidAge) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = { dogViewModel.Dog.Nome = inputNameDog

                        if (inputNameDog.isNotBlank() && inputAgeDog.isNotBlank()) {
                            onNext()
                        } else if (inputNameDog.isNotBlank() && inputAgeDog.isBlank()){
                            isValidAge = false
                        } else if (inputNameDog.isBlank() && inputAgeDog.isNotBlank()){
                            isValidName = false
                        } else if (inputNameDog.isBlank() && inputAgeDog.isBlank()) {
                            isValidAge = false
                            isValidName = false
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
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



// STEP-2 IMAGEM
@Composable
fun PhotoPickerDog(dogViewModel: DogViewModel,onBack: () -> Unit, onNext: () -> Unit): Unit {

    var ImagemDoCao by remember { mutableStateOf(dogViewModel.Dog.Imagem) }

    val photoPickerLauncherDog = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
           // inputNameDog = it
            //dogViewModel.Dog.Imagem = it
        }
    )

    var isValidImage by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .background(
                color = Salmon,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Show us your dog!",
                modifier = Modifier.padding(bottom = 10.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Box (
                modifier = Modifier

            ) {
                Image(
                    painter = painterResource(id = R.drawable.imageplaceholder),
                    contentDescription = "placeholderimage",
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
                    model = ImagemDoCao,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            if (!isValidImage) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
            }

            Button(onClick = {
                photoPickerLauncherDog.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )

            },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(50.dp),


                colors = ButtonDefaults.buttonColors(
                    containerColor = OrangeOpacity65
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
                    .padding(top = 10.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
            ) {


                Button(onClick = onBack,
                    modifier = Modifier

                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
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

                Button(onClick = onNext,/*
                onClick = {
                    if (dogViewModel.Dog.Imagem != null) {
                        onNext()
                    } else {
                        isValidImage = false
                    }
                }, USAR QUANDO DER PARA METER A IMAGEM NO MOMENTO TA INT
                */
                    modifier = Modifier
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
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

// STEP-3 VAR INPUTS DE DESCRIPTION
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDescBox(dogViewModel: DogViewModel,onBack: () -> Unit, onNext: () -> Unit) {
    var inputDescDog by remember { mutableStateOf(dogViewModel.Dog.Descricao) }
    var isValidDesc by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .background(
                color = Salmon,
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
                text = "Make a description of your Dog",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            OutlinedTextField(
                value = inputDescDog,
                onValueChange = { inputDescDog = it
                    dogViewModel.Dog.Descricao= it},
                label = {
                    Text(
                        "Insert a description...",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center,
                        color = OrangeOpacity65,
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
            if (!isValidDesc) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
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
                        containerColor = Orange
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

                Button(onClick = { dogViewModel.Dog.Descricao = inputDescDog

                    if (inputDescDog.isNotBlank() ) {
                        onNext()
                    } else if (inputDescDog.isBlank()){
                        isValidDesc = false
                    }
                },
                    modifier = Modifier

                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
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


// STEP-4 VAR INPUTS RACA E SEXO DO CAO
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBreedSexBox(dogViewModel: DogViewModel,onBack: () -> Unit,onNext:() -> Unit) {
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

            var inputBreedDog by remember { mutableStateOf(dogViewModel.Dog.Raca) }
            var inputSexDog by remember { mutableStateOf(dogViewModel.Dog.Sexo) }
            var isValidBreed by remember { mutableStateOf(true) }
            var isValidSex by remember { mutableStateOf(true) }

            // What's your Dog's Name?
            Text(
                text = "What's your Dog's Breed?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Input DogName
            OutlinedTextField(
                value = inputBreedDog,
                onValueChange = {
                    dogViewModel.Dog.Raca= it
                    inputBreedDog = it
                },
                label = { Text("Insert here dog's breed...",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFBF8B7E),
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .background(Color.White, shape = CircleShape),


                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )
            if (!isValidBreed) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                )
            }
            // What's your Dog's Age?
            Text(
                text = "What's your Dog's Sex?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Input DogAge
            OutlinedTextField(
                value = inputSexDog,
                onValueChange = {
                    dogViewModel.Dog.Sexo= it
                    inputSexDog = it
                },
                label = { Text("Insert here dog's sex...",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFBF8B7E),
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .background(Color.White, shape = CircleShape),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )

            if (!isValidSex) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
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

                Button(onClick = { dogViewModel.Dog.Raca = inputBreedDog
                    dogViewModel.Dog.Sexo = inputSexDog

                    if (inputBreedDog.isNotBlank() && inputSexDog.isNotBlank()) {
                        onNext()
                    } else if (inputBreedDog.isNotBlank() && inputSexDog.isBlank()){
                        isValidSex = false
                    } else if (inputBreedDog.isBlank() && inputSexDog.isNotBlank()){
                        isValidBreed = false
                    } else if (inputBreedDog.isBlank() && inputSexDog.isBlank()) {
                        isValidSex = false
                        isValidBreed = false
                    }

                },
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

// STEP-5 VAR INPUTS DE LOCALIZACAO DO CAO
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputLocBox(dogViewModel: DogViewModel,onBack: () -> Unit,onNext:() -> Unit) {
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

            var inputLocDog by remember { mutableStateOf(dogViewModel.Dog.Localidade) }
            var isValidLoc by remember { mutableStateOf(true) }


            Text(
                text = "What's your Dog Location?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            OutlinedTextField(
                value = inputLocDog,
                onValueChange = {
                    dogViewModel.Dog.Localidade= it
                    inputLocDog = it
                },
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
            if (!isValidLoc) {
                Text(
                    text = "Please fill the empty field !",
                    color = Color.Red,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
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

                Button(onClick = { dogViewModel.Dog.Localidade = inputLocDog

                    if (inputLocDog.isNotBlank() ) {
                        onNext()
                    } else if (inputLocDog.isBlank()){
                        isValidLoc = false
                    }
                },
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

// STEP-6 VAR INPUTS DE CHIP OU NAO DO CAO
@Composable
fun InputChipBox(dogViewModel: DogViewModel,onBack: () -> Unit,onNext:() -> Unit) {
    var inputChipDog by remember { mutableStateOf(dogViewModel.Dog.Chip) }
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

                Button(onClick = { inputChipDog = false; onBack() },
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

                Button(onClick = { inputChipDog = true; onNext() },
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

// STEP-7 VAR INPUTS DE FINISH OU NAO DO CAO
@Composable
fun InputFinishBox(dogViewModel: DogViewModel,onBack: () -> Unit,onNext:() -> Unit) {
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

