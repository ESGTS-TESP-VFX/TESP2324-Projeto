package com.tesp.tindogapp.pages

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Dog(val index: Int, val name: String, val breed: String, val location: String)

@Composable
fun GalleryPage() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DogGallery(
            dogs = listOf(
                Dog(index = 1, name = "Bob", breed = "Golden Retriever", location = "Carregado"),
                Dog(index = 2, name = "Buddy", breed = "Labrador", location = "VFX"),
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
                text = dog.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Breed: ${dog.breed}",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Location: ${dog.location}",
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
                Text(text = "Age: 3")

                Text(text = "Sex: M")
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun GalleryPagePreview() {
    GalleryPage()
}
