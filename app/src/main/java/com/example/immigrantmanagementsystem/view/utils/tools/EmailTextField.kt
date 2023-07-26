package com.example.immigrantmanagementsystem.view.utils.tools

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailTextField(message: String): String {
    var emailtext by remember { mutableStateOf("") }

    OutlinedTextField(
        value = emailtext,
        onValueChange = { it ->
            emailtext = it
        },
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        placeholder = { Text(text = "Enter the email address") },
        label = { Text(text = "Enter the email address") }
    )
    return emailtext
}