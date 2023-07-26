//package com.example.immigrantmanagementsystem.ui.utils
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.runtime.*
//
//import androidx.compose.runtime.saveable.rememberSaveable
//
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.example.immigrantmanagementsystem.R
//import com.example.immigrantmanagementsystem.data.auth.AuthViewModel
//import com.example.immigrantmanagementsystem.data.auth.Resource
//import com.example.immigrantmanagementsystem.ui.utils.tools.EmailTextField
//import com.example.immigrantmanagementsystem.ui.utils.tools.PasswordTextField
//import com.example.immigrantmanagementsystem.utils.navigation.Screen
//
//@Composable
//fun SignUpPage(viewModel: AuthViewModel, navController: NavHostController) {
//
//    val signupFlow = viewModel?.signupFlow?.collectAsState()
//    val context = LocalContext.current
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        SignUpImage()
//        Spacer(modifier = Modifier.height(18.dp))
//        Text(
//            text = "Create Account",
//            color = Color.Blue,
//            fontWeight = FontWeight.Bold,
//            fontSize = 36.sp
//        )
//        Spacer(modifier = Modifier.height(18.dp))
//
//        val emailtext = EmailTextField(message = "Enter the email address")
//
//        Spacer(modifier = Modifier.height(18.dp))
//        val password = PasswordTextField("Enter the Password")
//        Spacer(modifier = Modifier.height(18.dp))
//        val re_password = PasswordTextField("Re-enter the Password")
//
//        Spacer(modifier = Modifier.height(18.dp))
//
//        Button(
//            onClick = {
//                if (password == re_password) {
//                    viewModel?.signup(emailtext, password)
//                }
//                else {
//                    Toast.makeText(context, "Passwords don't match", Toast.LENGTH_SHORT).show()
//
//                }
//
//            },
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
//            shape = RoundedCornerShape(20.dp),
//            modifier = Modifier
//                .fillMaxWidth(0.7f)
//                .padding(10.dp)
//                .height(38.dp)
//        ) {
//            Text(text = "Sign Up", fontWeight = FontWeight.SemiBold)
//        }
//        signupFlow?.value?.let {
//            when(it) {
//                is Resource.Failure -> {
//                    val context = LocalContext.current
//                    Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
//                }
//                Resource.Loading -> {
//                    CircularProgressIndicator()
//                }
//                is Resource.Success -> navController.navigate(Screen.Login.route)
//            }
//        }
//    }
//}
//@Composable
//fun SignUpImage() {
//    Box() {
//        Image(
//            painterResource(id = R.drawable.create ),
//            contentDescription = "Login Image",
//            contentScale = ContentScale.Fit
//        )
//    }
//}
