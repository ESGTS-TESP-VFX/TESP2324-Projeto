package com.tesp.tindogapp.pages

import androidx.compose.foundation.Image
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.viewmodels.KennelGalleryViewModel
import com.tesp.tindogapp.viewmodels.KennelViewModel
import com.tesp.tindogapp.viewmodels.MainViewModel

@Composable
fun GalleryPage(navController: NavHostController = rememberNavController(),
                mainViewModel: MainViewModel = MainViewModel(),
                kennelViewModel: KennelGalleryViewModel = viewModel()) {

    kennelViewModel.SetContext(mainViewModel)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dog's Gallery",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        DogGallery(
            dogs = kennelViewModel.Dogs,
            navController = navController
        )
    }
}


@Composable
fun DogGallery(dogs: List<Dog>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(dogs) { dog ->
            DogItem(dog = dog, navController = navController)
        }
    }
}


@Composable
fun DogItem(dog: Dog, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("SeeDogPage/${dog.Id}")
            }
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFDBD2), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFDBD2))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fotocao5),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFDBD2))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${dog.Nome}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Location: ${dog.Localidade}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Age: ${dog.Idade}")
                    if(dog.Sexo == "Masculino"){
                        Text(text = "Sex: M")
                    }else if(dog.Sexo == "Feminino"){
                        Text(text = "Sex: F")
                    }
                    Text(text = "Raca: ${dog.Raca}")
                }
            }
        }
    }
}


@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun GalleryPagePreview() {
    GalleryPage()
}
