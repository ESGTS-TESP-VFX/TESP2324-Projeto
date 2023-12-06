package com.tesp.tindogapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.footerBeMyFriend


@Preview(showBackground = true, widthDp = 380)
@Composable
fun SeletorCaes(navHostController: NavHostController = rememberNavController()): Unit {

    val caes = listOf(
        R.drawable.fotocao1,
        R.drawable.fotocao2,
        R.drawable.fotocao3,
        R.drawable.fotocao4,
        R.drawable.fotocao5
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {

        // Galeria do seletor de cães

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(caes.size) { index ->
                    Image(
                        painter = painterResource(id = caes[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(MaterialTheme.colorScheme.background)
                            .clickable { /* Handle click if needed */ },
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        // Slider de distância - Alterar a cor
        Column() {
            val distancia = remember { mutableStateOf(5.0f) }
            Slider(
                value = distancia.value,
                onValueChange = { distancia.value = it },
                valueRange = 1f..20f,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFFF8969),
                    activeTrackColor = Color(0xFF7EAB9C),
                    inactiveTrackColor = Color(0xFFB4E2D2),
                )
                )
            Text(
                text = "≤ ${distancia.value} km",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(0xFF7EAB9C), blurRadius = 15f)
                ),
            )
        }

        // Botão de busca
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {

            Image(
                painter = painterResource(id = R.drawable.botaobusca),
                contentDescription = "busca",
                modifier = Modifier
                    .size(100.dp, 100.dp)
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