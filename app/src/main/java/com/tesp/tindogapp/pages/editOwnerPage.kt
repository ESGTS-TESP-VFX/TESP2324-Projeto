package com.tesp.tindogapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.DeleteProfileButton
import com.tesp.tindogapp.components.EditProfileButton
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.components.OwnerProfileDescBox
import com.tesp.tindogapp.components.VarInputDescBox
import com.tesp.tindogapp.viewmodels.MainViewModel
import com.tesp.tindogapp.viewmodels.MatchDogViewModel
import com.tesp.tindogapp.viewmodels.OwnerEditViewModel
import com.tesp.tindogapp.viewmodels.OwnerPageViewModel
import com.tesp.tindogapp.viewmodels.OwnerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, heightDp = 800, widthDp = 380)
@Composable
fun editOwnerPage(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = MainViewModel(),
    ownerEditViewModel: OwnerEditViewModel = OwnerEditViewModel(),
): Unit {


    if (!ownerEditViewModel.Loaded)
        ownerEditViewModel.SetContext(viewModel)

    Column {
        Logotipo()

        Column(
            modifier = Modifier
                .background(
                    Color(0xFFFFDBD2),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Column {

                OutlinedTextField(
                    value = ownerEditViewModel.Nome,
                    onValueChange = {
                        ownerEditViewModel.Nome = it
                    },
                    label = {
                        Text(
                            "Insert here your name...",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            textAlign = TextAlign.Center,
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

            Column (

            ) {
                Text(text = "About me",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                OutlinedTextField(
                    value = ownerEditViewModel.Descricao,
                    onValueChange = {
                        ownerEditViewModel.Descricao = it
                    },
                    label = {
                        Text(
                            "Example",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            textAlign = TextAlign.Center,
                            color = Color(0xFFBF8B7E),
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 15.dp, 0.dp, 20.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .height(150.dp),


                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )
            }

                Text(text = "My doghouse",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                Color(0xFFBF8B7E),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .fillMaxWidth()
                            .height(100.dp),

                        ){
                        LazyRow(
                            modifier = Modifier
                                .align(alignment = Center)
                        ) {
                            items(ownerEditViewModel.Dogs) { dog ->
                                Image(painter = painterResource(id = R.drawable.fotocao1),
                                    contentDescription = "cao",
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                        .size(55.dp)
                                        .clickable {
                                            navController.navigate("EditDogPage/${dog.Id}")
                                        }
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {

                            navController.navigate("pickDog")
                                  },
                        modifier = Modifier
                            .offset(y = 45.dp)
                            .align(Alignment.Center)
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF8769)
                        ),
                    ) {
                        Text(text = "See more")
                    }


                }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate("SeeOwnerPage/${ownerEditViewModel.Id}") },
                    modifier = Modifier
                        .height(65.dp)
                        .padding(0.dp, 20.dp, 0.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF807471)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = "Cancel",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Button(
                    onClick = {
                        ownerEditViewModel.DoSaveOwner(viewModel, navController)
                    },
                    modifier = Modifier
                        .height(65.dp)
                        .padding(0.dp, 20.dp, 0.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF807471)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = "Save",
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



