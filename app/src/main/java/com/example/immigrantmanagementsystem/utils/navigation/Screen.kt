package com.example.immigrantmanagementsystem.utils.navigation

sealed class Screen(val route: String) {
    // create all the screen objects and their routes


    // routes for the normal users:
    object UserHome: Screen("user_home")
    object UserForm: Screen("user_form")
    object LandingUser: Screen("landing_page")
    object Feedbackpage: Screen("feedback_page")

    // routes for the admin user:
    object AdminAuth: Screen("admin_auth")
    object AdminView: Screen("admin_view")


}
