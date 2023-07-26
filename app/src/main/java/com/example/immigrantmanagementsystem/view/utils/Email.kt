package com.example.immigrantmanagementsystem.view.utils


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.example.immigrantmanagementsystem.data.NotificationDataItem
import com.example.immigrantmanagementsystem.network.notification.fetchNotificationsFromServer

fun sendEmail(email: String, ctx: Context) {
    val url = "https://immigrants-management-system.onrender.com/notifications?receiver=$email"

    fetchNotificationsFromServer(url, ctx,
        onSuccess = { notifications ->
            // Iterate through the notifications and send emails for each one
            notifications.forEach { notification ->
                sendEmailToImmigrant(notification, ctx)
            }
        },
        onError = { errorMessage ->
            Log.d("mailno", errorMessage.toString())
            Toast.makeText(ctx, "Could not send email at the moment", Toast.LENGTH_SHORT).show()
        }
    )
}

private fun sendEmailToImmigrant(notification: NotificationDataItem, ctx: Context) {
    // Create an Intent to send an email
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:${notification.receiver}")
        putExtra(Intent.EXTRA_SUBJECT, "Immigration Application Update")
        putExtra(Intent.EXTRA_TEXT, notification.message)
    }

    // Check if there is an email app installed on the device
    if (intent.resolveActivity(ctx.packageManager) != null) {
        // Open the email client to send the email
        ctx.startActivity(intent)
    } else {
        // Handle the case where no email app is installed
        // e.g., show a toast message or an error dialog
    }
}
