package com.tesp.tindogapp.pages

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.DogProfileDescBox
import com.tesp.tindogapp.ui.theme.Brown
import com.tesp.tindogapp.ui.theme.Salmon
import com.tesp.tindogapp.viewmodels.DogEditViewModel
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.ui.theme.OrangeOpacity65
import com.tesp.tindogapp.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDogPage(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = MainViewModel(),
    dogEditViewModel: DogEditViewModel = DogEditViewModel(),
    dog3Id: Int = 0
) {
    dogEditViewModel.SetContext(mainViewModel, dog3Id)

    var inputNameDog by remember { mutableStateOf(dogEditViewModel.Dog.Nome) }
    var inputAgeDog by remember { mutableStateOf(dogEditViewModel.Dog.Idade.toString()) }
    var inputBreedDog by remember { mutableStateOf(dogEditViewModel.Dog.Raca) }
    var inputGenderDog by remember { mutableStateOf(dogEditViewModel.Dog.Sexo) }
    var inputLocationDog by remember { mutableStateOf(dogEditViewModel.Dog.Localidade) }
    var inputChipStatus by remember { mutableStateOf(dogEditViewModel.Dog.Chip.toString()) }
    var inputDescStatus by remember { mutableStateOf(dogEditViewModel.Dog.Descricao) }
    var inputVaccines by remember {
        mutableStateOf(
            dogEditViewModel.Dog.Vacinas?.joinToString(",") ?: ""
        )
    }

    Box(
        modifier = Modifier
            .background(
                color = Salmon,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(20.dp, 0.dp, 20.dp, 0.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.fotocao3),
                contentDescription = "fotocao",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .background(
                        color = Salmon,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .fillMaxSize()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Input DogName
                    OutlinedTextField(
                        value = inputNameDog,
                        onValueChange = {
                            inputNameDog = it
                            dogEditViewModel.Dog.Nome = it
                        },
                        label = {
                            Text(
                                "Insert here dog's name...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Input DogAge
                    OutlinedTextField(
                        value = inputAgeDog,
                        onValueChange = {
                            inputAgeDog = it
                            dogEditViewModel.Dog.Idade = it.toIntOrNull() ?: 0
                        },
                        label = {
                            Text(
                                "Insert here dog's age...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Input DogName
                    OutlinedTextField(
                        value = inputBreedDog,
                        onValueChange = {
                            inputBreedDog = it
                            dogEditViewModel.Dog.Raca = it
                        },
                        label = {
                            Text(
                                "Insert here dog's breed...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Input DogName
                    OutlinedTextField(
                        value = inputGenderDog,
                        onValueChange = {
                            inputGenderDog = it
                            dogEditViewModel.Dog.Sexo = it
                        },
                        label = {
                            Text(
                                "Insert here your dog's sex...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Input DogName
                    OutlinedTextField(
                        value = inputLocationDog,
                        onValueChange = {
                            inputLocationDog = it
                            dogEditViewModel.Dog.Localidade = it
                        },
                        label = {
                            Text(
                                "Insert here dog's location...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    fun convertBooleanToYesNo(boolean: Boolean): String {
                        return if (boolean) "Yes" else "No"
                    }
                    val dogChipStatusYesNo = convertBooleanToYesNo(dogEditViewModel.Dog.Chip)

                    // Input DogName
                    OutlinedTextField(
                        value = dogChipStatusYesNo,
                        onValueChange = {
                            inputChipStatus = it
                            dogEditViewModel.Dog.Chip = it.equals("Yes", ignoreCase = true)

                        },
                        label = {
                            Text(
                                "Insert here dog's chip...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                                color = OrangeOpacity65,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = CircleShape),

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )
                    )

                }

                Column (
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)
                ){
                    OutlinedTextField(
                        value = inputDescStatus,
                        onValueChange = {  inputDescStatus = it
                                                    dogEditViewModel.Dog.Descricao = it
                                        },
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
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { navController.navigate("SeeDogPage/$dog3Id") },
                            modifier = Modifier
                                .height(65.dp)
                                .padding(0.dp, 20.dp, 0.dp, 0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Brown
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {

                            Text(
                                text = "Cancel Edit",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                        }

                        Button(
                            onClick = { dogEditViewModel.DoSaveDog(navController) },
                            modifier = Modifier
                                .height(65.dp)
                                .padding(0.dp, 20.dp, 0.dp, 0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Brown
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {

                            Text(
                                text = "Submit Edit",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
