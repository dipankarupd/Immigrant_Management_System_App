package com.example.immigrantmanagementsystem.view.user.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.utils.navigation.Screen

@Composable
fun LandingPageUser(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Define the gradient colors you want
        val gradientColors = listOf(Color(0xFF006064), Color(0xFF00ACC1))

        // Create a vertical gradient brush
        val gradientBrush = Brush.verticalGradient(gradientColors)

        // Apply the gradient background to the Box
        Box(modifier = Modifier.fillMaxSize().background(brush = gradientBrush)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Please select the operation to perform ", color = Color.White)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { navController.navigate(Screen.UserForm.route) }) {
                    Text(
                        text = "Fill the Immigration Form: ",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Button(onClick = { navController.navigate(Screen.Feedbackpage.route) }) {
                    Text(
                        "Give Feedback",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
