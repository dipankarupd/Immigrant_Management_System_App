package com.example.immigrantmanagementsystem.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

fun PostData(
    name: String,
    pnoText: String,
    email: String,
    ageText: String,
    gender: String,
    arrivalDate: String,
    returnDate: String,
    visatype: String,
    country: String,
    context: Context
) {
    val passportNo = pnoText.toInt()
    val age = ageText.toInt()
    var approval = "pending"


    // url with localhost ip addr port and route
    val url = "https://immigrants-management-system.onrender.com/immigrants"



    val requestData = JSONObject()

    val queue = Volley.newRequestQueue(context)

    requestData.put("name", name)
    requestData.put("passportno", passportNo)
    requestData.put("email", email)
    requestData.put("gender", gender)
    requestData.put("country", country)
    requestData.put("age", age)
    requestData.put("arrivaldate", arrivalDate)
    requestData.put("staytime", returnDate)
    requestData.put("visatype", visatype)
    requestData.put("approval", approval)

    val request = object : JsonObjectRequest(Request.Method.POST,url,requestData,
    Response.Listener<JSONObject> {response ->
        Log.d("Response", "Success")
        Toast.makeText(context, "Successfully posted to API", Toast.LENGTH_SHORT).show()
    },
        Response.ErrorListener {
            Log.d("Response", "fail ", it)
            Toast.makeText(context, "Cannot post data", Toast.LENGTH_SHORT).show()

        }
    ){}
    queue.add(request)
}