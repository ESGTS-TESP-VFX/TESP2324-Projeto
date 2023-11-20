package com.tesp.tindogapp.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NextButton() {

    val onNextClick: () -> Unit = {
        var inputName = ""
        var inputAge = ""
        println("Dog's Name: $inputName, Dog's Age: $inputAge")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8769)
            ),
            shape = RoundedCornerShape(16.dp)

        ) {
            Text(
                text = "Next",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }
}