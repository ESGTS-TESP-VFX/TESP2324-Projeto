package com.tesp.tindogapp.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tesp.tindogapp.components.footerBeMyFriend
import com.tesp.tindogapp.viewmodels.MainViewModel
import com.tesp.tindogapp.viewmodels.MatchDogViewModel


@Preview(showBackground = true, heightDp = 750, widthDp = 380)
@Composable
fun likeDislike(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = MainViewModel(),
    matchDogViewModel: MatchDogViewModel = MatchDogViewModel(),
    dogId: Int=0
): Unit {
    matchDogViewModel.SetContext(viewModel, dogId);

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
                )
                {
                    // Imagem principal da galeria
                    Image(
                        painter = painterResource(
                            id = matchDogViewModel.MatchDog?.Imagem ?: 2130968601
                        ),
                        contentDescription = "foto da galeria",
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    // Botão de seleção para o cão à procura de companhia
                    Button(
                        onClick = { },
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
                            painter = painterResource(
                                id = matchDogViewModel.Dog?.Imagem ?: 2130968601
                            ),
                            contentDescription = "botao_redondo"
                        )
                    }
                }


            }


            // Textos (alterar para json)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                var text = "";
                if (matchDogViewModel.MatchDog?.Nome != null) {
                    text =
                        "${matchDogViewModel.MatchDog?.Nome ?: ""}, ${matchDogViewModel.MatchDog?.Idade ?: 0}";
                }
                Text(
                    text = text,
                    style = androidx.compose.ui.text.TextStyle( // ???
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                Text(
                    text = "${matchDogViewModel.MatchDog?.Localidade ?: ""}",
                    style = androidx.compose.ui.text.TextStyle( // ???
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }
            Text(
                text = "${matchDogViewModel.MatchDog?.Descricao ?: ""}",
                style = androidx.compose.ui.text.TextStyle( // ???
                    fontSize = 14.sp
                )
            )

            // Botões like e dislike (ajustar com o que Rodrigo fez)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dislike),
                    contentDescription = "dislike",
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clickable {
                            navController.navigate("pickDog")
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "like",
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clickable {
                            navController.navigate("pickDog")
                        }
                )
            }

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
