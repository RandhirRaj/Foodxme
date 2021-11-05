package com.randhir.foodxme

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.StreamEncoder
import java.io.InputStream
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
val dateParseFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS"
const val dateParseFormat2 = "yyyy-MM-dd'T'HH:mm:ss"

var token:String?="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE2MDU2ODk4NjAsImV4cCI6MTkyMTA0OTg2MCwiaXNzIjoiaHR0cDovL3E4b25saW5lc2hvcHBpbmcuY29tIiwiYXVkIjpbImh0dHA6Ly9xOG9ubGluZXNob3BwaW5nLmNvbS9yZXNvdXJjZXMiLCJub3BfYXBpIl0sImNsaWVudF9pZCI6ImNhMTRjNmQ3LWI1ZDUtNDg2Ny04OWQ4LTJmMDZmOThhZDhiOCIsInN1YiI6ImNhMTRjNmQ3LWI1ZDUtNDg2Ny04OWQ4LTJmMDZmOThhZDhiOCIsImF1dGhfdGltZSI6MTYwNTY4OTg1OSwiaWRwIjoibG9jYWwiLCJzY29wZSI6WyJub3BfYXBpIiwib2ZmbGluZV9hY2Nlc3MiXSwiYW1yIjpbInB3ZCJdfQ.1MUXsPV_iwqls5uUinwrjL7FQvQkLePoxVkm3Epy2MHig0raLT0YvDbTEgC8JWaStdMXN0Ad9H8lhzQM99c6dY0W5aTV3Eym0mETzuH53t1IRlcRObdN-vYMOSd0ATpmO2vJcyyJhzS8kEHdvcFmf9OJPI_84_KSqQi1UmjA15le6q3DJX9-xOi5QKQ6OfeDGXaM0jdlf2b_g94Hs0w3yTeKcbfm_gmIeKZpuQhgfHl1UzBamvkwa4G05BR8jIExJJRCu2rFCKB3dm4pvPFl9SrnQcR_y5TbpTsuf71OO0AFADXsjD7GCqDT_uGwcHV00sOOxeXeBdlUcoJuBsgZyQ"
//var phoneNo:String?=null

@SuppressLint("SimpleDateFormat")
fun String?.dateFormat(pattern: String): String {
    var df =
        if (this.isValidDate(dateParseFormat)) SimpleDateFormat(dateParseFormat) else SimpleDateFormat(
            dateParseFormat2
        )
    val calendar = Calendar.getInstance()
    calendar.time = df.parse(this)
    df = SimpleDateFormat(pattern)
    return df.format(calendar.time)
}

/**
 * Returns the [ConnectivityManager] instance.
 *
 * @return [ConnectivityManager] instance
 */
internal fun Context?.connectivityManager(): ConnectivityManager? {
    if (this == null) return null
    return ContextCompat.getSystemService(this, ConnectivityManager::class.java)
}

/**
 * Checks whether device is connected to network or not
 * @return true-> if connected, false-> if not connected
 */
@Suppress("DEPRECATION")
fun Context?.isOnline(): Boolean {
    this?.run {
        val netWorkInfo: NetworkInfo? = connectivityManager()?.activeNetworkInfo
        return netWorkInfo != null && netWorkInfo.isConnected
    }
    return false
}

//fun Context?.isVpnEnable(): Boolean {
//    val connectivityManager =
//        this?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//        val network = connectivityManager.activeNetwork
//        val capabilities = connectivityManager.getNetworkCapabilities(network)
//        capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
//
//    } else {
//        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_VPN)!!.isConnectedOrConnecting
//    }
//}



fun AppCompatTextView.appendColon(string: String?) {
    this.text = ": \t$string"
}


@SuppressLint("SimpleDateFormat")
fun String?.isValidDate(format: String): Boolean {
    val sdf = SimpleDateFormat(format)
    return try {
        sdf.parse(this)
        true
    } catch (parseException: ParseException) {
        false
    }
}