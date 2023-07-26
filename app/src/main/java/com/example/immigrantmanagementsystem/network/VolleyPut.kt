import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.immigrantmanagementsystem.data.ImmigrantData
import org.json.JSONObject

fun updateImmigrant(
    immigrantData: ImmigrantData,
    approvalStatus: String,
    context: Context,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    // Convert passportno to a string
    val passportno = immigrantData.passportno.toString()

    // Construct the complete URL for the PUT request
    val URL = "https://immigrants-management-system.onrender.com/immigrants/accept/$passportno"

    // Create the JSON object for the PUT request
    val jsonObject = JSONObject().apply {
        put("approval", approvalStatus)
    }

    // Create the PUT request using JsonObjectRequest
    val request = JsonObjectRequest(
        Request.Method.PUT, URL, jsonObject,
        Response.Listener { response ->
            // Request successful, update the approval status in the local data
            immigrantData.approval = approvalStatus
            onSuccess()
        },
        Response.ErrorListener { error ->
            // Request failed, handle the error
            onError("Volley error: ${error.message}")
        }
    )

    // Add the request to the RequestQueue
    Volley.newRequestQueue(context).add(request)
}
