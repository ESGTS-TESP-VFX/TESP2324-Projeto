package com.tesp.tindogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.SignUpCorpo
import com.tesp.tindogapp.pages.*
//import com.tesp.tindogapp.pages.paginaB
import com.tesp.tindogapp.ui.theme.TinDogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TinDogAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            loginPage(navController)
                        }
                        composable("home") {
                            Text(text = "Ecrã por Criar")
                        }

                        composable("signPage") {
                            SignUpCorpo(navController)
                        }
                    }
                }
            }
        }
    }
}
