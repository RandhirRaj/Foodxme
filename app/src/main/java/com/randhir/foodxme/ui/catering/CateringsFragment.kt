package com.randhir.foodxme.ui.catering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import kotlinx.android.synthetic.main.app_bar_main.appBarLayoutMain
import kotlinx.android.synthetic.main.fragment_caterings.*

class CateringsFragment : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_caterings, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.GONE

        layoutCartCatering.setOnClickListener {
            navController!!.navigate(CateringsFragmentDirections.actionCateringsFragmentToCartFragment())
        }

        imageViewBackCatering.setOnClickListener() {
            requireActivity().onBackPressed()
        }
        layoutShowMeBuffets.setOnClickListener{
            navController!!.navigate(CateringsFragmentDirections.actionCateringsFragmentToCateringsResultsFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
    }

}