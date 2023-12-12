package com.tesp.tindogapp.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun MatchPorCao(navHostController: NavHostController = rememberNavController()): Unit {

    val match1 = listOf(
        R.drawable.fotocao1,
        R.drawable.fotocao2,
        R.drawable.fotocao3,
    )

    val match2 = listOf(
        R.drawable.fotocao4,
        R.drawable.fotocao5
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Box {

            // Galeria de matchs do cão1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp)
            )
            {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(match1.size) { index ->
                        Image(
                            painter = painterResource(id = match1[index]),
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

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                // Cão1
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
                        painter = painterResource(id = R.drawable.fotocao4),
                        contentDescription = "botao_redondo"
                    )
                }
            }
        }

        Box {
            // Galeria de matchs do cão2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp)
            )
            {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(match2.size) { index ->
                        Image(
                            painter = painterResource(id = match2[index]),
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

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                // Cão2
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
                        painter = painterResource(id = R.drawable.fotocao2),
                        contentDescription = "botao_redondo"
                    )
                }
            }
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
