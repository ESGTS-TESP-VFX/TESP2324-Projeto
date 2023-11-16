package com.tesp.tindogapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tesp.tindogapp.R

//@Preview ()
@Composable
fun Logotipo () {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(20.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.tindog_logo),
            contentDescription = R.string.logotipoDesc.toString()
        )
    }
}