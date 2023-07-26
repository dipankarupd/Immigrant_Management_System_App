package com.example.immigrantmanagementsystem.view.user.pages

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.network.feedback.PostFeedbackData


@Composable
fun FeedbackScreen(navController: NavHostController) {

    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Feedback!",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            style = MaterialTheme.typography.h1
        )
        Spacer(Modifier.height(20.dp))
        val passportno = Passport()
        Spacer(modifier = Modifier.height(10.dp))
        var  userfeedback = feedback()
        Spacer(modifier = Modifier.height(10.dp))
        var userrating = Rating()
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            PostFeedbackData(passportno, userfeedback, userrating, context)
//            Toast.makeText(context, "Feedback given", Toast.LENGTH_SHORT).show()
//            navController.navigate(Screen.UserHome.route)
        }) {
            Text(text = "Submit feedback", textAlign = TextAlign.Center, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }

    }
}

@Composable
fun Passport(): String{
    var num by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        value = num,
        onValueChange = { it ->
            num = it
        },
        placeholder = { Text(text = "Passport number eg: 10100")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return num
}

@Composable
fun feedback(): String {
    var fb by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        value = fb,
        onValueChange = { it ->
            fb = it
        },
        placeholder = { Text(text = "Enter the feedback") },
        label = { Text(text = "Enter the feedback") },
    )
    return fb
}

@Composable
fun Rating():String {
    var value by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = value,
        onValueChange = {
            value = it
        },
        modifier = Modifier
            .fillMaxWidth(0.3f),
        label = { Text(text = "Rating")},
        placeholder = { Text(text = "Enter Rating")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return value
}