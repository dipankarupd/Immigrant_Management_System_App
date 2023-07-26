package com.example.immigrantmanagementsystem.view.admin.util
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.R
import com.example.immigrantmanagementsystem.utils.navigation.Screen

@Composable
fun AdminLogin(navController: NavHostController) {
    
    val context = LocalContext.current
    
    var username by remember {
        mutableStateOf("")
    }
    
    var passwordText by remember {
        mutableStateOf("")
    }
    
    var passwordVisible by remember {
        mutableStateOf(false    )
    }
    var icon = if(passwordVisible) {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    }
    else {
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    }
    
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Admin Login Page",
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.height(35.dp))
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
            },
            placeholder = { Text(text = "name") },
            leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "")}
        )

        Spacer(modifier = Modifier.height(10.dp))
        
        OutlinedTextField(
            value = passwordText, 
            onValueChange = {
            passwordText = it
        },
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                ) {
                   Icon(painter = icon, contentDescription = "password icon") 
                }
            },
            placeholder = { Text(text = "password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(passwordVisible) {
                VisualTransformation.None
            }   else {
                    PasswordVisualTransformation()
            }
        )

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            onClick = { authenticate(username, passwordText, navController, context) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan)
        ) {
            Text(text = "Login")
        }
    }
}

// admin authentication.. simple if name and password are both admin, allow the access else
// show a snackbar / toast message

fun authenticate(username: String, password: String, navController: NavHostController, context: Context) {


    if(username == "admin" && password == "admin") {
        navController.navigate(Screen.AdminView.route)
    } else {
        Toast.makeText(context, "Can't login. Invalid credentials", Toast.LENGTH_SHORT).show()
    }
}