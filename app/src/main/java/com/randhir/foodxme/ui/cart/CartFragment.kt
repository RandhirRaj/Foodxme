package com.randhir.foodxme.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R

class CartFragment :BaseFragment() {
    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_cart, container, false)
        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireActivity() as MainActivity). getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity). getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back);
        (requireActivity() as MainActivity).textViewActionBarName.text="Basket"
    }

}