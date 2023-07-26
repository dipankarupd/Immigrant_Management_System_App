package com.example.immigrantmanagementsystem.view.utils.tools

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.immigrantmanagementsystem.R

@Composable
fun PasswordTextField(message: String) : String{
    var showPassword by rememberSaveable() {
        mutableStateOf("")
    }
    var passwordVisibility by remember() {
        mutableStateOf(false)
    }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    }
    else {
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    }
    OutlinedTextField(
        value = showPassword,
        onValueChange = { it ->
            showPassword = it
        },
        placeholder = { Text(text = "Enter the password") },
        label = { Text(text = "Enter the password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "visibility icon"
                )
            }
        },
        visualTransformation = if(passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
    return showPassword
}