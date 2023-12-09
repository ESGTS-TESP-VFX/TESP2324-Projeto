package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.utils.isCodeValid
import com.tesp.tindogapp.utils.isEmailValid

@Preview()
@Composable

fun RecoverCodeBody(navController: NavController = rememberNavController()) {
    Box(
        modifier = Modifier
            .background(
                Color(0xFFFFDBD2),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var validAnswer by remember {
                mutableStateOf(true)
            }
            Text(
                text = stringResource(id = R.string.enter_code),
                fontFamily = FontFamily.Monospace,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 5.dp)
            )
            Row(

                modifier = Modifier
                    //.fillMaxWidth()
                    .background(
                        colorResource(id = R.color.coral_claro),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
                    .height(70.dp)
                    .width(250.dp),


                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var pincode1 = InputCodeDigit()
                var pincode2 = InputCodeDigit()
                var pincode3 = InputCodeDigit()
                var pincode4 = InputCodeDigit()
                var pincode = pincode1 + pincode2 + pincode3 + pincode4

                validAnswer = isCodeValid(pincode)
            }


            InputCodeButtonComponent {
                if (validAnswer) {
                    navController.navigate("pickDog")
                    //temos de mudar rota
                }
            }
            //este texto só aparece quando os dados de login forem inválidos

            if (!validAnswer) {
                Text(
                    text = stringResource(id = R.string.invalid_code),
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF0000),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
        }
    }
}



