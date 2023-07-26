package com.example.immigrantmanagementsystem

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.immigrantmanagementsystem.utils.navigation.SetUpNavGraph


class MainActivity : ComponentActivity() {



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            SetUpNavGraph()
        }
    }
}

