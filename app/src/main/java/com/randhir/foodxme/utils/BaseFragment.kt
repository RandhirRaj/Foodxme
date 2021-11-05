package com.blisbelly.restaurant

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.randhir.foodxme.activity.MainActivity


abstract class BaseFragment : Fragment(){
    private val connectionChangeReceiver = ConnectionChangeReceiver()
    private val connectionFilter = IntentFilter(MainActivity.ACTION_NETWORK_CHANGE)
    abstract fun onNetworkChange(isNetworkAvailable: Boolean)

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(requireContext())
            .registerReceiver(connectionChangeReceiver, connectionFilter)
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(connectionChangeReceiver)
        super.onDestroy()
    }

    private inner class ConnectionChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val isConnectionAvailable =
                intent?.getBooleanExtra(MainActivity.EXTRA_CONNECTION_STATE, false) ?: false
            onNetworkChange(isConnectionAvailable)
        }
    }

}
