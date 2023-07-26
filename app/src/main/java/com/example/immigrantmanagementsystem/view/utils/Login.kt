//package com.example.immigrantmanagementsystem.ui.utils
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//import androidx.navigation.NavHostController
//import com.example.immigrantmanagementsystem.R
//import com.example.immigrantmanagementsystem.data.auth.AuthViewModel
//import com.example.immigrantmanagementsystem.data.auth.Resource
//import com.example.immigrantmanagementsystem.ui.utils.tools.EmailTextField
//import com.example.immigrantmanagementsystem.ui.utils.tools.PasswordTextField
//
//import com.example.immigrantmanagementsystem.utils.navigation.Screen
//
//
//@Composable
//fun LoginPage(viewModel: AuthViewModel, navController: NavHostController) {
//
//
//    // this is a login flow which will say whether the process is success, failure or loading
//    val loginFlow = viewModel?.loginFlow?.collectAsState()
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            LoginImage()
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            val email = EmailTextField(message = "Enter the email address")
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            val password = PasswordTextField(message = "Enter the password")
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Button(
//                onClick = {
//                    viewModel?.login(email, password)
//
//                },
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
//                shape = RoundedCornerShape(20.dp),
//                modifier = Modifier
//                    .fillMaxWidth(0.7f)
//                    .padding(10.dp)
//                    .height(38.dp)
//            ) {
//                Text(text = "Sign In", fontWeight = FontWeight.SemiBold)
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            ClickableText(navController)
//        }
//        loginFlow?.value?.let {
//            when(it) {
//                is Resource.Failure -> {
//                    val context = LocalContext.current
//                    Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
//                }
//                Resource.Loading -> {
//                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                }
//                is Resource.Success -> navController.navigate(Screen.UserForm.route)
//            }
//        }
//    }
//}
//@Composable
//fun LoginImage() {
//    Box() {
//        Image(
//            painterResource(id = R.drawable.login),
//            contentDescription = "Login Image",
//            contentScale = ContentScale.Fit
//        )
//    }
//}
//
//@Composable
//fun ClickableText(navController: NavHostController) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Forgot Password",
//            color = Color.Blue,
//            fontSize = 18.sp,
//            modifier = Modifier.clickable {
//                navController.navigate(Screen.ForgotPassword.route)
//            }
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = "Create a new account",
//            color = Color.Blue,
//            fontSize = 18.sp,
//            modifier = Modifier.clickable {
//                navController.navigate(Screen.SignUp.route)
//            }
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = "Login as Admin",
//            color = Color.Blue,
//            fontSize = 18.sp,
//            modifier = Modifier.clickable {
//                navController.navigate(Screen.AdminAuth.route)
//            }
//        )
//    }
//}