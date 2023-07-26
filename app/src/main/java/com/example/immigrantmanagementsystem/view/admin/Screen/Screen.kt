package com.example.immigrantmanagementsystem.view.admin.Screen

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.data.ImmigrantData
import com.example.immigrantmanagementsystem.network.fetchDataFromServer

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.example.immigrantmanagementsystem.view.utils.sendEmail
import updateImmigrant

// Custom colors with adjusted brightness
val CustomYellow = Color(0xFFFFD700) // Darker shade of yellow
val CustomGreen = Color(0xFF006400) // Darker shade of green
val CustomRed = Color(0xFF8B0000) // Darker shade of red

@Composable
fun ImmigrantList(url: String, context: Context, navController: NavHostController) {
    var immigrantDataList by remember { mutableStateOf<List<ImmigrantData>>(emptyList()) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(url) {
        fetchDataFromServer(
            url = url,
            context = context,
            onSuccess = { dataList ->
                immigrantDataList = dataList
            },
            onError = {
                Log.e("X", it)
            }
        )
    }

    LazyColumn {
        items(immigrantDataList) { immigrantData ->
            ImmigrantCard(immigrantData, navController, context)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImmigrantCard(immigrantData: ImmigrantData, navController: NavHostController, context: Context) {
    var approvalStatus by remember { mutableStateOf(immigrantData.approval) }

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Name: ${immigrantData.name}",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Passport Number: ${immigrantData.passportno}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Email: ${immigrantData.email}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Age: ${immigrantData.age}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Country: ${immigrantData.country}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Arrived on: ${immigrantData.arrivaldate}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Visa Expiry: ${immigrantData.staytime}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Visa Type: ${immigrantData.visatype}",
                style = MaterialTheme.typography.body1
            )
            ApprovalStatusText(approvalStatus = immigrantData.approval)

            // Add clickable "Approve" and "Reject" texts when the status is "pending"
            if (approvalStatus == "pending") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    ClickableText(
                        text = AnnotatedString("Approve"),
                        onClick = {
                            updateImmigrant(
                                immigrantData,
                                "approved",
                                context,
                                onSuccess = {
                                    // Trigger recomposition after data is updated
                                    approvalStatus = "approved"
                                    Toast.makeText(context, "Approved", Toast.LENGTH_SHORT).show()
                                },
                                onError = { errorMessage ->
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }
                            )

                            // send the email:
                            sendEmail(immigrantData.email,context)
                        },
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Text("      |       ", fontWeight = FontWeight.Bold, fontSize = 20.sp) // Add a separator between "Approve" and "Reject"
                    ClickableText(
                        text = AnnotatedString("Reject"),
                        onClick = {
                            updateImmigrant(
                                immigrantData,
                                "rejected",
                                context,
                                onSuccess = {
                                    // Trigger recomposition after data is updated
                                    approvalStatus = "rejected"
                                    Toast.makeText(context, "Rejected", Toast.LENGTH_SHORT).show()
                                },
                                onError = { errorMessage ->
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }
                            )

                            sendEmail(immigrantData.email,context)
                        },
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ApprovalStatusText(approvalStatus: String) {
    val textColor = when (approvalStatus) {
        "pending" ->  CustomYellow
        "approved" -> CustomGreen
        "rejected" -> CustomRed
        else -> Color.Black // Fallback color
    }

    Text(
        text = "Approval: $approvalStatus",
        style = MaterialTheme.typography.body1.copy(
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    )
}
