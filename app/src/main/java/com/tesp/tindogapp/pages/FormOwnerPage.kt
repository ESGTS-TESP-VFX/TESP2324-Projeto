package com.tesp.tindogapp.pages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.tesp.tindogapp.components.VarInputDescBox
import com.tesp.tindogapp.components.VarInputNameAgeBox
import com.tesp.tindogapp.components.VarInputNameBox
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun FormOwnerPage(navController: NavHostController = rememberNavController()) {
    var currentStep by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentStep) {
            1 -> Step1(onNext = { currentStep = 2 })
            2 -> Step2(onBack = { currentStep = 1 }, onNext = { currentStep = 3 })
            3 -> Step3(onBack = { currentStep = 2 }, onNext = { currentStep = 4})
        }
    }
}


@Composable
fun Step1(onNext: () -> Unit) {
    Column {
        Logotipo()
        InputOwnerNameBox(onNext = onNext)
    }
}

/*
@Composable
fun Step1(onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDogNameBox(onNext = onNext)
    }
}
*/

@Composable
fun Step2(onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        InputDescBox(onBack = onBack, onNext = onNext)
    }
}

@Composable
fun Step3(onBack: () -> Unit, onNext: () -> Unit) {
    Column {
        Logotipo()
        PhotoPicker(name = "", modifier = Modifier, onBack = onBack, onNext = onNext)

    }
}


@Composable
fun InputOwnerNameBox(onNext: () -> Unit) {


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

            var respostaValida by remember { mutableStateOf(true) }

            val isValid = VarInputNameBox()

            if (!respostaValida) {
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
                        if (isValid) {
                            onNext()
                        } else {
                            respostaValida = false
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

            VarInputDescBox()

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

            var respostaValida by remember { mutableStateOf(false) }

            VarInputNameAgeBox()

            if (!respostaValida){
                Text(text = "Não é valido!")
            }

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


@Composable
fun PhotoPicker(name: String, modifier: Modifier = Modifier, onBack: () -> Unit, onNext: () -> Unit) {

    /*
    val packageName = LocalContext.current.packageName
    val placeholderImageUri: Uri = Uri.parse("android.resource://$packageName/${R.drawable.tindog_logo}")
    */

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImageUri = it
        }
    )

    Box (
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column{

            Text(
                text = "Show us how you look !",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Spacer(modifier = Modifier.size(20.dp))

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = selectedImageUri,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(text = selectedImageUri?.encodedPath.toString() )

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBF8B7E)
                ),
                onClick = {
                    photoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }) {
                Text(text = "Choose Image")
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