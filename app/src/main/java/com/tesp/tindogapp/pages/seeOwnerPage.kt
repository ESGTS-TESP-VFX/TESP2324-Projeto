package com.tesp.tindogapp.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.components.DeleteProfileButton
import com.tesp.tindogapp.components.EditProfileButton
import com.tesp.tindogapp.components.Logotipo
import com.tesp.tindogapp.components.OwnerProfileDescBox
import com.tesp.tindogapp.components.VarInputDescBox

@Preview(showBackground = true, heightDp = 800, widthDp = 380)
@Composable
fun seeOwnerPage(navController: NavHostController = rememberNavController()): Unit {

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
                    Text(text = "Name",
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    OwnerProfileDescBox()

                    Row (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        EditProfileButton()
                        DeleteProfileButton {
                            // Lógica para excluir o perfil quando o usuário confirma
                        }

                    }

                }
            }
        }
}


