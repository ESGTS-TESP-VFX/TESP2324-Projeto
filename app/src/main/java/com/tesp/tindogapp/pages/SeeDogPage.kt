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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.DeleteDogProfileButton

import com.tesp.tindogapp.components.DogProfileDescBox
import com.tesp.tindogapp.components.EditDogProfileButton

import com.tesp.tindogapp.ui.theme.Salmon
import com.tesp.tindogapp.viewmodels.DogPageViewModel
import com.tesp.tindogapp.viewmodels.MainViewModel


@Preview(showBackground = true, heightDp = 800, widthDp = 380)
@Composable
fun SeeDogPage(navController: NavHostController = rememberNavController(),
               viewModel: MainViewModel = MainViewModel(),
               DogPageViewModel: DogPageViewModel = DogPageViewModel(),
               dog2Id: Int=0
): Unit {
    DogPageViewModel.SetContext(viewModel, dog2Id)
    var ChipResult by remember { mutableStateOf(DogPageViewModel.Dog2?.Chip) }
    var SexResult by remember { mutableStateOf(DogPageViewModel.Dog2?.Sexo) }
    Column {
        Image(
            painter = painterResource(id = R.drawable.fotocao3), // ViewModel
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
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "${DogPageViewModel.Dog2?.Nome ?: ""}",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = "${DogPageViewModel.Dog2?.Idade  ?: ""} Anos",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "${DogPageViewModel.Dog2?.Raca ?: ""}",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                if (SexResult == "Masculino"){
                    Text(text = "Masculino",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        ))
                }else if(SexResult == "Feminino"){
                    Text(text = "Feminino",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),

                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "${DogPageViewModel.Dog2?.Localidade ?: ""}",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                if (ChipResult == false){
                    Text(text = "Chip:Não",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        ))
                }else{
                    Text(text = "Chip:Sim",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),){
                Text(text = "Vaccines",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Column() {
                DogProfileDescBox()

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    EditDogProfileButton {
                        navController.navigate("EditDogPage/$dog2Id")
                    }
                    DeleteDogProfileButton {
                        // Lógica para excluir o perfil quando o utilizador confirma
                    }

                }
            }
        }
    }
}