package com.tesp.tindogapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tesp.tindogapp.R
import com.tesp.tindogapp.viewmodels.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun NavigationTopBar(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = MainViewModel(),
    drawerContent: @Composable () -> Unit = {}
): Unit {
    val scope = rememberCoroutineScope()
    var state = rememberDrawerState(DrawerValue.Closed);

    Column {
        if (state.isClosed) {
            Row {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            scope.launch {
                                if (state.isClosed)
                                    state.open()
                                else
                                    state.close()
                            }
                        },
                    painter = painterResource(id = R.drawable.menu_button_of_three_horizontal_lines),
                    contentDescription = ""
                )
            }
        }

        ModalNavigationDrawer(
            content = drawerContent,
            modifier = Modifier,
            scrimColor = Color(0x4DFF8769),
            drawerContent = {
                Row (modifier = Modifier
                    .clip(RoundedCornerShape(0,10,10, 0))
                    ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(0,10,10, 0))
                    ) {
                        Button(
                            onClick = {  navController.navigate("pickDog") },
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFFF8769),
                                contentColor = Color(0xFFFFFFFF)),
                            modifier = Modifier
                                //.fillMaxWidth()
                                .padding(6.dp)
                                .width(200.dp)

                        ) {
                            Text(text = "Home")
                        }
                        Button(
                            onClick = {  navController.navigate("seeOwnerPage/${viewModel.Owner.Id}") },
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFFF8769),
                                contentColor = Color(0xFFFFFFFF)),
                            modifier = Modifier
                                //.fillMaxWidth()
                                .padding(6.dp)
                                .width(200.dp)

                        ) {
                            Text(text = "Profile")
                        }
                        Button(
                            onClick = {  navController.navigate("MatchesPage") },
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFFF8769),
                                contentColor = Color(0xFFFFFFFF)),
                            modifier = Modifier
                                //.fillMaxWidth()
                                .padding(6.dp)
                                .width(200.dp)

                        ) {
                            Text(text = "Matches")
                        }
                        Button(
                            onClick = {  navController.navigate("KennelPage") },
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFFF8769),
                                contentColor = Color(0xFFFFFFFF)),
                            modifier = Modifier
                                //.fillMaxWidth()
                                .padding(6.dp)
                                .width(200.dp)

                        ) {
                            Text(text = "Kennel")
                        }
                    }
                    Image(
                        modifier = Modifier
                            .size(16.dp)
                            .clickable {
                                scope.launch {
                                    if (state.isClosed)
                                        state.open()
                                    else
                                        state.close()
                                }
                            },
                        painter = painterResource(id = R.drawable.menu_button_of_three_horizontal_lines),
                        contentDescription = ""
                    )
                }
            },
            drawerState = state
        )
    }

}