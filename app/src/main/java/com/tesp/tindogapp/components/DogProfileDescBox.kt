package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tesp.tindogapp.viewmodels.DogPageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogProfileDescBox( DogPageViewModel: DogPageViewModel = DogPageViewModel(),) {


    Column (
        modifier = Modifier.padding(0.dp,30.dp,0.dp,0.dp)

    ) {


        Text(text = "Dog Description",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 15.dp, 0.dp, 0.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .height(150.dp),
            ) {

            Text(modifier = Modifier.padding(15.dp,15.dp,0.dp,0.dp),
                text= "${DogPageViewModel.Dog2?.Descricao ?: ""}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = Color(0xFFBF8B7E),
            )
        }
            }


    }

