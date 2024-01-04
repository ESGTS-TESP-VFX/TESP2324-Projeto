package com.tesp.tindogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tesp.tindogapp.components.NavigationTopBar
import com.tesp.tindogapp.components.SignUpBody
import com.tesp.tindogapp.pages.*
import com.tesp.tindogapp.ui.theme.TinDogAppTheme
import com.tesp.tindogapp.viewmodels.MainViewModel
import com.tesp.tindogapp.viewmodels.MatchDogViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TinDogAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    var viewModel = viewModel<MainViewModel>();

                    NavHost(navController = navController, startDestination = "login") {
                        // Mario, Joao, Mafalda, Alexandre
                        composable("login") { LoginPage(navController, viewModel, viewModel())}
                        composable("signPage") {SignUpBody(navController)}

                        // Rodrigo, Marcos, Alen
                        composable("pickDog") {PickRighView(navController, viewModel, viewModel())}
                        composable("MatchesPage") {NavigationTopBar(navController = navController){Text(text = "MatchesPage")}}
                        composable("match/{dogId}",
                            arguments = listOf(navArgument("dogId") { type = NavType.IntType })
                        ) {
                            var dogId = it.arguments?.getInt("dogId");
                            NavigationTopBar(navController = navController){
                                likeDislike(navController, viewModel,MatchDogViewModel(), dogId?:0 )
                            }}

                        //Pedro & Rafael
                        composable("formOwnerPage") {FormOwnerPage(navController,  viewModel, viewModel())}
                        composable("seeOwnerPage") {NavigationTopBar(navController = navController){Text(text = "seeOwnerPage")}}

                        //Ricardo,Bruno e Tomás
                        composable("EditDogPage") {EditDogPage(navController)}

                        // Tomas & Ricardo
                        composable("formDogPage") {FormDogPage(navController,viewModel, viewModel())}
                        composable("SeeDogPage/{dogId}",
                            arguments = listOf(navArgument("dogId") { type = NavType.IntType })
                        ) {
                            var dogId = it.arguments?.getInt("dogId");
                            SeeDogPage(navController, dog2Id = dogId?:0)
                        }
                        composable("EditDogPage") {EditDogPage(navController)}
                        composable("KennelPage") {
                            NavigationTopBar(navController = navController){
                                GalleryPage(navController, viewModel, viewModel())
                            }
                        }

                    }
                }
            }
        }
    }
}

