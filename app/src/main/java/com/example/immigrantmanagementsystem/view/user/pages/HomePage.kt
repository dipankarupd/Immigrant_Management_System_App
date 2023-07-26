package com.example.immigrantmanagementsystem.view.user.pages

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.R
import com.example.immigrantmanagementsystem.utils.navigation.Screen

@Composable
fun FirstPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Easy, fast and reliable",
            fontWeight = FontWeight.SemiBold,
            color = androidx.compose.ui.graphics.Color.Blue
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { navController.navigate(route = Screen.LandingUser.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Blue)
        ) {
            Text(
                text = "Get Started",
                color = androidx.compose.ui.graphics.Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Continue as Admin",
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.AdminAuth.route)
            }
        )
    }
}