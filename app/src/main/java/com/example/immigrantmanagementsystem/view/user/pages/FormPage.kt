package com.example.immigrantmanagementsystem.view.user.pages


import android.os.Build

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.immigrantmanagementsystem.network.PostData
import com.example.immigrantmanagementsystem.view.user.util.CountryField
import com.example.immigrantmanagementsystem.view.user.util.DateConfig
import com.example.immigrantmanagementsystem.view.user.util.GenderField
import com.example.immigrantmanagementsystem.view.user.util.VisaField
import com.example.immigrantmanagementsystem.view.utils.tools.EmailTextField

lateinit var age : String
lateinit var arrivalDate : String
lateinit var returnDate : String
lateinit var gender : String
lateinit var visatype: String



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormPage() {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Please fill the form below",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        val name =  NameText()
        Spacer(modifier = Modifier.height(8.dp))
        val pno = PassportNumberText()
        Spacer(modifier = Modifier.height(8.dp))
        val email = EmailTextField(message = "Enter the email address")
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){
            age = AgeField()
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier
                .width(130.dp)
            ){
                gender = GenderField()
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box{
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                arrivalDate = DateConfig("Date of arrival")
                Spacer(modifier = Modifier.height(8.dp))
                returnDate = DateConfig("Date of return")
            }
        }
        val country = CountryField()
        Spacer(modifier = Modifier.height(8.dp))

        visatype = VisaField()

        Button(
            onClick = {
                PostData(name, pno, email, age, gender, arrivalDate, returnDate, visatype, country, context)

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.72f)
                .padding(12.dp)
                .height(42.dp),
            shape = RoundedCornerShape(20.dp)

        ) {
            Text(text = "Submit Form", color = Color.White)
        }
    }
}

@Composable
fun NameText(): String {
    var name by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        value = name,
        onValueChange = { it ->
            name = it
        },
        placeholder = { Text(text = "Enter the name") },
        label = { Text(text = "Enter the name") },
    )
    return name
}

@Composable
fun PassportNumberText(): String{
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
fun AgeField():String {
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
        label = { Text(text = "Age")},
        placeholder = { Text(text = "Enter age")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return value
}