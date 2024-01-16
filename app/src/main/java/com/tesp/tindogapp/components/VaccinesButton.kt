package com.tesp.tindogapp.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tesp.tindogapp.R
import com.tesp.tindogapp.ui.theme.Orange
import com.tesp.tindogapp.ui.theme.OrangeOpacity65
import com.tesp.tindogapp.ui.theme.Salmon



@Composable
fun VaccinesButton(onDeleteConfirmed: () -> Unit ): Unit {

    var showDialog by remember { mutableStateOf(false) }

    fun showConfirmationDialog() {
        showDialog = true
    }
    fun closeConfirmationDialog() {
        showDialog = false
    }



    Button(
        onClick = { showConfirmationDialog() },
        modifier = Modifier
            .width(55.dp)
            .height(55.dp)
            .padding(0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF807471)
        ),
        shape = CircleShape
    ) {

        Text(text = "V",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        )

    }
    if (showDialog) {
        AlertDialog(
            containerColor = Salmon ,
            modifier = Modifier.border(2.dp, Color.Black, shape = RoundedCornerShape(21.dp)),
            onDismissRequest = { closeConfirmationDialog() },
            title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row (

                        ){
                            Box (modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.Gray)
                                .clickable { /* Handle click */ }){
                                Text(
                                    "CDV",
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(8.dp),
                                    color = Color.White,

                                )

                            }
                            Spacer(modifier = Modifier.width(35.dp))
                            Box (modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.Gray)
                                .clickable { /* Handle click */ }){
                                Text(
                                    "CPV2",
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(8.dp),
                                    color = Color.White,

                                    )

                            }
                            Spacer(modifier = Modifier.width(35.dp))
                            Box (modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color.Gray)
                                .clickable { /* Handle click */ }){
                                Text(
                                    "HPIV",
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(8.dp),
                                    color = Color.White,

                                    )

                            }

                        }
                    }
                },


            confirmButton = {
                Button(
                    onClick = {
                        closeConfirmationDialog()
                        onDeleteConfirmed()
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFFF8769),
                        contentColor = Color(0xFFFFFFFF))
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                Button(
                    onClick = { closeConfirmationDialog() },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF807471),
                        contentColor = Color(0xFFFFFFFF)),
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(50.dp))
            }


        )
    }
}