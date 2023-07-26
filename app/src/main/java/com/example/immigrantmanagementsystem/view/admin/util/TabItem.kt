package com.example.immigrantmanagementsystem.view.admin.util

import android.graphics.drawable.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.immigrantmanagementsystem.R
import com.example.immigrantmanagementsystem.view.admin.Screen.AcceptedScreen
import com.example.immigrantmanagementsystem.view.admin.Screen.AllScreen
import com.example.immigrantmanagementsystem.view.admin.Screen.PendingScreen
import com.example.immigrantmanagementsystem.view.admin.Screen.RejectedScreen

// represents the screen in tab layout
// type is composable func and returns nothing
typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(val title: String, val screens: ComposableFun) {
    object All: TabItem("All", { AllScreen(rememberNavController()) })
    object Accepted: TabItem("Accepted", { AcceptedScreen(rememberNavController()) })
    object Rejected: TabItem("Rejected", { RejectedScreen(rememberNavController()) })
    object Pending: TabItem("Pending", { PendingScreen(rememberNavController()) })
}
