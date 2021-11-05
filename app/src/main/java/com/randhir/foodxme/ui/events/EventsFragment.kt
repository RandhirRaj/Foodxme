package com.randhir.foodxme.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.R

class EventsFragment  : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)

        return root
    }
}