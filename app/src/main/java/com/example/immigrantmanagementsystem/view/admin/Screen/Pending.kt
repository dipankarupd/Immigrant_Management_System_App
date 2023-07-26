package com.example.immigrantmanagementsystem.view.admin.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun PendingScreen(navController: NavHostController) {
    val URL = "https://immigrants-management-system.onrender.com/immigrants/pending"
    val context = LocalContext.current
    ImmigrantList(url = URL, context, navController)

}