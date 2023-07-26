package com.example.immigrantmanagementsystem.view.admin.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun AcceptedScreen(navController: NavHostController) {

    val URL = "https://immigrants-management-system.onrender.com/immigrants/approved"
    val context = LocalContext.current
    ImmigrantList(url = URL, context, navController)

}