package com.tesp.tindogapp.pages

import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun GalleryPage(navController: NavHostController = rememberNavController()) {
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
            dogs = listOf(
                Dog(Id = 1, Nome = "Bob", Idade = 3, Descricao = "Golden Retriever", Localidade = "Carregado", Imagem = R.drawable.fotocao3),
                Dog(Id = 2, Nome = "Buddy", Idade = 3, Descricao = "Labrador", Localidade = "VFX", Imagem = R.drawable.fotocao5),
            )
        )
    }
}


@Composable
fun DogGallery(dogs: List<Dog>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(dogs) { dog ->
            DogItem(dog = dog)
        }
    }
}

@Composable
fun DogItem(dog: Dog) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFDBD2), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Gray)
            ) {
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = dog.Nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            /*Text(
                text = "Location: ${dog.Localidade}",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )*/

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

                //Text(text = "Sex: ${dog.}")
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun GalleryPagePreview() {
    GalleryPage()
}
