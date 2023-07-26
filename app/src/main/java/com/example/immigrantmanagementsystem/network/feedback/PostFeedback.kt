package com.example.immigrantmanagementsystem.network.feedback

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

fun PostFeedbackData(
    passportNo: String,
    feedback: String,
    rating: String,
    context: Context
) {

    val pno = passportNo.toInt()
    val rat = rating.toInt()
    // URL to the endpoint where you want to post the feedback data
    val url = "https://immigrants-management-system.onrender.com/feedback"

    val requestData = JSONObject()
    requestData.put("passportNo", pno)
    requestData.put("comment", feedback)
    requestData.put("rating", rat)


    val queue = Volley.newRequestQueue(context)

    val request = object : JsonObjectRequest(
        Request.Method.POST, url, requestData,
        Response.Listener<JSONObject> { response ->
            Log.d("Response", "Success")
            Toast.makeText(context, "Feedback submitted successfully", Toast.LENGTH_SHORT).show()
        },
        Response.ErrorListener { error ->
            Log.d("Response", "Error: ${error.networkResponse}")
            Toast.makeText(context, "Failed to submit feedback", Toast.LENGTH_SHORT).show()
        }
    ) {}
    queue.add(request)
}
