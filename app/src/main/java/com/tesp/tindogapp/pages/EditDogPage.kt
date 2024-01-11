package com.tesp.tindogapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.components.DeleteDogProfileButton

import com.tesp.tindogapp.components.DogProfileDescBox
import com.tesp.tindogapp.components.EditDogProfileButton
import com.tesp.tindogapp.ui.theme.Brown

import com.tesp.tindogapp.ui.theme.Salmon



@Composable
fun EditDogPage(navController: NavHostController = rememberNavController()): Unit {

    Column {
        Image(
            painter = painterResource(id = R.drawable.fotocao3),
            contentDescription = "fotocao",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .background(
                    color = Salmon,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxSize()
                .padding(20.dp,0.dp,20.dp,0.dp)
        ) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Alberto",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = "10 anos",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Rafeiro",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = "Macho",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),

                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Sintra",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = "Chip(Sim)",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),){
                Text(text = "Vaccines",
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Column() {
                DogProfileDescBox()

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {/*TODO*/},
                        modifier = Modifier
                            .height(65.dp)
                            .padding(0.dp, 20.dp, 0.dp, 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Brown
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {

                        Text(text = "Cancel Edit",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                    }

                    Button(onClick = {/*TODO*/},
                        modifier = Modifier
                            .height(65.dp)
                            .padding(0.dp, 20.dp, 0.dp, 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Brown
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {

                        Text(text = "Submit Edit",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                    }


                }
            }


        }
    }
}