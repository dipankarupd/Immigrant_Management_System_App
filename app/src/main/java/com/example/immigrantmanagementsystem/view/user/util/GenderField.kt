package com.example.immigrantmanagementsystem.view.user.util

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GenderField() : String {
    val genderList = listOf("M", "F")
    var selectedGender by remember {
        mutableStateOf(genderList[0])
    }
    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Enter the gender", fontWeight = FontWeight.SemiBold)
            Row(horizontalArrangement = Arrangement.Start) {
                genderList.forEach {gender ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = gender)
                        Spacer(modifier = Modifier.width(2.dp))
                        RadioButton(
                            selected = (selectedGender == gender),
                            onClick = {
                                selectedGender = gender
                            },
                        )
                    }
                }
            }
        }

    }
    return selectedGender
}