package com.rst.cashit.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_your_order.*

class OrderFragment : BaseFragment() {
    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_your_order, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back)
        (requireActivity() as MainActivity).textViewActionBarName.text="Food Orders"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        locationTypeHome.setOnClickListener { v: View? ->
            locationTypeHome.isChecked = true
            locationTypeWork.isChecked = false
            locationTypeOther.isChecked = false
            nestedTodayView.visibility=View.VISIBLE
            imageViewNoOrderAvailable.visibility=View.GONE
            cardViewHistory.visibility=View.GONE
        }

        locationTypeWork.setOnClickListener { v: View? ->
            locationTypeHome.isChecked = false
            locationTypeWork.isChecked = true
            locationTypeOther.isChecked = false
            nestedTodayView.visibility=View.GONE
            imageViewNoOrderAvailable.visibility=View.VISIBLE
            cardViewHistory.visibility=View.GONE
        }

        locationTypeOther.setOnClickListener { v: View? ->
            locationTypeHome.isChecked = false
            locationTypeWork.isChecked = false
            locationTypeOther.isChecked = true
            nestedTodayView.visibility=View.GONE
            imageViewNoOrderAvailable.visibility=View.GONE
            cardViewHistory.visibility=View.VISIBLE
        }
    }


}