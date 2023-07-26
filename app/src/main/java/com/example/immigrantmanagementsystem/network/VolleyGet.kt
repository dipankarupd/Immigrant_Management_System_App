package com.example.immigrantmanagementsystem.network

import android.content.Context
import com.example.immigrantmanagementsystem.data.ImmigrantData
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray


fun getData(
    url: String,
    context: Context,
    onSuccess: (List<ImmigrantData>) -> Unit,
    onError: (String) -> Unit
) {
    fetchDataFromServer(url, context, onSuccess, onError)
}

fun fetchDataFromServer(
    url: String,
    context: Context,
    onSuccess: (List<ImmigrantData>) -> Unit,
    onError: (String) -> Unit
) {

    val request = JsonArrayRequest(Request.Method.GET, url, null,
        Response.Listener<JSONArray> { response ->
            try {
                val data = parseJsonArray(response)
                onSuccess(data)
            } catch (e: Exception) {
                onError("Error parsing response: ${e.message}")
            }
        },
        Response.ErrorListener { error ->
            onError("Volley error: ${error.message}")
        })

    // Add the request to the RequestQueue.
    Volley.newRequestQueue(context).add(request)
}

fun parseJsonArray(jsonArray: JSONArray): List<ImmigrantData> {
    val dataList = mutableListOf<ImmigrantData>()
    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        val age = jsonObject.getInt("age")
        val approval = jsonObject.getString("approval")
        val arrivaldate = jsonObject.getString("arrivaldate")
        val country = jsonObject.getString("country")
        val email = jsonObject.getString("email")
        val gender = jsonObject.getString("gender")
        val id = jsonObject.getString("id")
        val name = jsonObject.getString("name")
        val passportno = jsonObject.getInt("passportno")
        val staytime = jsonObject.getString("staytime")
        val visatype = jsonObject.getString("visatype")

        val immigrantData = ImmigrantData(
            age, approval, arrivaldate, country, email, gender, id,
            name, passportno, staytime, visatype
        )

        dataList.add(immigrantData)
    }
    return dataList
}
