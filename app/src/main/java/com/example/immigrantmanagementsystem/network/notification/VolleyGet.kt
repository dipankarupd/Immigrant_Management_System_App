package com.example.immigrantmanagementsystem.network.notification

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.immigrantmanagementsystem.data.NotificationDataItem
import org.json.JSONArray

fun parseJsonArray(response: JSONArray): List<NotificationDataItem> {
    val notifications = mutableListOf<NotificationDataItem>()

    for (i in 0 until response.length()) {
        val notificationObject = response.getJSONObject(i)
        val id = notificationObject.getString("_id")
        val message = notificationObject.getString("message")
        val receiver = notificationObject.getString("receiver")

        val notification = NotificationDataItem(id, message, receiver)
        notifications.add(notification)
    }

    return notifications
}

fun fetchNotificationsFromServer(
    url: String,
    context: Context,
    onSuccess: (List<NotificationDataItem>) -> Unit,
    onError: (String) -> Unit
) {
    val request = JsonArrayRequest(
        Request.Method.GET, url, null,
        Response.Listener<JSONArray> { response ->
            Log.d("Server Response", response.toString()) // Print the response to the log
            try {
                val notifications = parseJsonArray(response)
                onSuccess(notifications)
            } catch (e: Exception) {
                onError("Error parsing response: ${e.message}")
            }
        },
        Response.ErrorListener { error ->
            onError("Volley error: ${error.message}")
        })

    // Add the request to the RequestQueue
    Volley.newRequestQueue(context).add(request)
}
