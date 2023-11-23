package com.tesp.tindogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun NavigationTopBar(
    navController: NavController = rememberNavController(),
    drawerContent: @Composable () -> Unit = {}
): Unit {
    val scope = rememberCoroutineScope()
    var state = rememberDrawerState(DrawerValue.Closed);

    Column {
        Row {
            Button(onClick = {
                scope.launch {
                    if (state.isClosed)
                        state.open()
                    else
                        state.close()
                }
            }, modifier = Modifier) {
                Icon(Icons.Sharp.Build, contentDescription = "")
            }

            Text(text = "teste")
        }


        ModalNavigationDrawer(
            content = drawerContent,
            modifier = Modifier.fillMaxSize(),
            drawerContent = {
                Column(
                    modifier = Modifier
                        .background(Color.Red)
                ) {
                    Text(
                        text = "Link A",
                        modifier = Modifier.clickable { navController.navigate("home") })
                    Text(
                        text = "Link B",
                        modifier = Modifier.clickable { navController.navigate("login") })
                }
            },
            drawerState = state
        )
    }

}