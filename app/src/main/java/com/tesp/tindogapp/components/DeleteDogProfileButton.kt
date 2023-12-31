package com.tesp.tindogapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tesp.tindogapp.R
import com.tesp.tindogapp.ui.theme.Brown
import com.tesp.tindogapp.ui.theme.Salmon



@Composable
fun DeleteDogProfileButton(onDeleteConfirmedDog: () -> Unit ): Unit {

    var showDialogDog by remember { mutableStateOf(false) }

    fun showConfirmationDialogDog() {
        showDialogDog = true
    }
    fun closeConfirmationDialogDog() {
        showDialogDog = false
    }

    Button(onClick = { showConfirmationDialogDog() },
        modifier = Modifier
            .height(65.dp)
            .padding(0.dp, 20.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Brown
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Text(text = "Delete Profile",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        )

    }
    if (showDialogDog) {
        AlertDialog(
            containerColor = Salmon ,
            modifier = Modifier.border(2.dp, Color.Black, shape = RoundedCornerShape(21.dp)),
            onDismissRequest = { closeConfirmationDialogDog() },
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cruzdog),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        "Are you sure?",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            },
            text = { Text("Do you really want to delete your profile? This process cannot be undone.",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            ) },

            confirmButton = {
                Button(
                    onClick = {
                        closeConfirmationDialogDog()
                        onDeleteConfirmedDog()
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
                    onClick = { closeConfirmationDialogDog() },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF807471),
                        contentColor = Color(0xFFFFFFFF)),
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(76.dp))
            }


        )
    }
}