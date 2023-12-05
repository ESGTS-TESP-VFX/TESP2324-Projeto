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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        // Menu de navegação - ### CORRIGIR ###
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            // NavigationTopBar()
        }
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
        // Slider de distância - Alterar a cor e incluir texto da legenda
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            val distancia = remember { mutableStateOf(5.0f) }
            Slider(
                value = distancia.value,
                onValueChange = { distancia.value = it },
                valueRange = 1f..10f
            )
            //Text(text = distancia.toString())
        }

        // Botão de busca
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
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