package com.example.immigrantmanagementsystem.view.user.util

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun VisaField(): String {

    val visaList = listOf("Business", "Student", "Tourist", "Other")
    var visatype by remember {
        mutableStateOf(visaList[0])
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Enter the Visa Type", fontWeight = FontWeight.SemiBold)
                Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(start = 8.dp)) {
                    visaList.forEach { visa ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = visa)
                            Spacer(modifier = Modifier.width(2.dp))
                            RadioButton(selected = visatype == visa, onClick = {
                                visatype = visa
                            })
                        }
                    }
                }
            }
        }
    }
    return visatype
}