package com.tesp.tindogapp.pages
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.CaixaInputs
import com.tesp.tindogapp.components.Logotipo

@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun loginPage(navController: NavHostController = rememberNavController()): Unit {
    Box(
        modifier = Modifier
            .padding(0.dp) // Set the margins here
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Logotipo()
            CaixaInputs()
            // Logotipo
            // box salmao recebe imputs
            //imputs

        }
    }
}

