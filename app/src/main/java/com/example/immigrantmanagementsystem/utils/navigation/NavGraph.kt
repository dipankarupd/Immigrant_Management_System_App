package com.example.immigrantmanagementsystem.utils.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.immigrantmanagementsystem.view.admin.page.MainScreen
import com.example.immigrantmanagementsystem.view.admin.util.AdminLogin
import com.example.immigrantmanagementsystem.view.user.pages.FeedbackScreen
import com.example.immigrantmanagementsystem.view.user.pages.FirstPage
import com.example.immigrantmanagementsystem.view.user.pages.FormPage
import com.example.immigrantmanagementsystem.view.user.pages.LandingPageUser

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetUpNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.UserHome.route
    ) {

        // composable for the Form page:
        composable(route = Screen.UserForm.route) {
            FormPage()
        }
        // composable for the user home page
        composable(route = Screen.UserHome.route) {
            FirstPage(navController)
        }

        // composable for admin auth page:
        composable(route = Screen.AdminAuth.route) {
            AdminLogin(navController)
        }

        composable(route = Screen.AdminView.route) {
            MainScreen(navController)
        }

        composable(route = Screen.LandingUser.route) {
            LandingPageUser(navController = navController)
        }

        composable(route = Screen.Feedbackpage.route) {
            FeedbackScreen(navController = navController)
        }
    }
}