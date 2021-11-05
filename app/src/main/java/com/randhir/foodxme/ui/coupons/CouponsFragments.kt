package com.randhir.foodxme.ui.coupons

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

class CouponsFragments : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_coupons, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back);
        (requireActivity() as MainActivity).textViewActionBarName.text = "Coupons &amp; Rewards"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE

        (requireActivity() as MainActivity).layoutCart.visibility=View.GONE
    }

}