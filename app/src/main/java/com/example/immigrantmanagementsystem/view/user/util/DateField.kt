package com.example.immigrantmanagementsystem.view.user.util

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateConfig(message: String): String {
    val calendarState = rememberSheetState()
    
    var currentDate by remember {
        mutableStateOf(message)
    }
    CalendarDialog(
        state = calendarState,
        selection = CalendarSelection.Date {date ->
            currentDate = date.toString()
        },
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            style = CalendarStyle.WEEK,
        )
    )
    
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
//        Text(
//            text = message,
//            fontSize = 21.sp,
//            color = Color.Blue,
//            fontWeight = FontWeight.SemiBold,
//            modifier = Modifier.clickable { calendarState.show() })
        OutlinedTextField(
            value = currentDate,
            onValueChange = { it ->
                currentDate = it
            },
            label = { Text(text = message)},
            modifier = Modifier.clickable { calendarState.show() },
            enabled = false
        )
//        Spacer(modifier = Modifier.width(15.dp))
//
//        Text(text = currentDate, fontSize = 17.sp)


    }
    return currentDate
}

