package com.tesp.tindogapp.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.tesp.tindogapp.components.NavigationTopBar
import com.tesp.tindogapp.components.footerBeMyFriend


@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun ecraMatch(navController: NavHostController = rememberNavController()): Unit {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Box {

            Row(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .aspectRatio(5f / 4f)
            )
            {
                // Imagem principal da galeria
                Image(
                    painter = painterResource(id = R.drawable.fotocao2),
                    contentDescription = "foto da galeria",
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            // Botão de seleção para o cão à procura de companhia
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .size(100.dp)
                        .border(
                            BorderStroke(4.dp, Color.Green),
                            CircleShape
                        )
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fotocao1),
                        contentDescription = "cao"
                    )
                }
            }

            // Botão de seleção para o dono do cão à procura de companhia
            Row(
                modifier = Modifier
                    .padding(top = 250.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                // Botão de seleção para o cão à procura de companhia
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .size(150.dp)
                        .border(
                            BorderStroke(4.dp, Color.Cyan),
                            CircleShape
                        )
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.helena),
                        contentDescription = "dono"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 355.dp)
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = "Bobi, 9",
                        style = androidx.compose.ui.text.TextStyle( // ???
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 8.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Text(
                        text = "Vila Franca de Xira",
                        style = androidx.compose.ui.text.TextStyle( // ???
                            fontSize = 20.sp,
                        ),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 8.dp)
                    )

                    Text(
                        text = "Helena",
                        style = androidx.compose.ui.text.TextStyle( // ???
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .weight(0.42f)
                            .padding(start = 8.dp)
                    )
                }
            }
        }


        // Textos (alterar para json)
        Text(
            text = "Esporte: Corrida na relva. Sou um cão de guarda reformado, minha tutora trouxe-me para viver na cidade. Gosto de outros cães e busco companhia para passeios.",
            style = androidx.compose.ui.text.TextStyle( // ???
                fontSize = 14.sp
            )
        )

        // Footer - Be My Friend
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            footerBeMyFriend()
        }
    }
}
