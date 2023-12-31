package com.example.immigrantmanagementsystem.view.user.util

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringArrayResource
import com.example.immigrantmanagementsystem.R


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryField(): String{
    var expanded by remember {
        mutableStateOf(false)
    }

    val items = stringArrayResource(R.array.countries_array)

    var selectedOptionText by remember {
        mutableStateOf(items[0])
    }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(
            value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Country of Birth") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)}
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            items.forEach{selectedText ->
                DropdownMenuItem(onClick = {
                    selectedOptionText = selectedText
                    expanded = false

                }) {
                    Text(text = selectedText)
                }
            }
        }
    }
    return selectedOptionText
}