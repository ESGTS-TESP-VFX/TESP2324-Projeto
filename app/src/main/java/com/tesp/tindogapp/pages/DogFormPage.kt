package com.tesp.tindogapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R

@Preview(showBackground = true, heightDp = 780, widthDp = 380)
@Composable
fun DogFormPage(navController: NavHostController = rememberNavController()): Unit {
    Column() {
        Logo()
    }
}

@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun Logo(): Unit {
    Box(modifier = Modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.tindog_logo), contentDescription = "")
    }

}
