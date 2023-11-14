package com.tesp.tindogapp.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun paginaA(navController: NavHostController= rememberNavController()) {
    Text(text = "Página A")
}