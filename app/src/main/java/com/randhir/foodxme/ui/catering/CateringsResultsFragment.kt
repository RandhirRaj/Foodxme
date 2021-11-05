package com.randhir.foodxme.ui.catering

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.fragment_caterings_results.*

class CateringsResultsFragment : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
var tabFrom:String="Breakfast Buffets"
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_caterings_results, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back)
        (requireActivity() as MainActivity).textViewActionBarName.text = "Catering"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE

        layoutCartNew.setOnClickListener {
            navController!!.navigate(CateringsResultsFragmentDirections.actionCateringsResultsFragmentToCateringsResultsDetailsFragment(tabFrom))
        }

        (requireActivity() as MainActivity).layoutCart.setOnClickListener {
            navController!!.navigate(CateringsResultsFragmentDirections.actionCateringsResultsFragmentToCartFragment())
        }
    }


    @SuppressLint("NewApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        breakfastBuffets.setOnClickListener { v: View? ->
            breakfastBuffets.isChecked = true
            lunchBuffets.isChecked = false
            dessertBuffets.isChecked = false

            breakfastBuffets.setTextColor(requireContext().getColor(R.color.black))
            lunchBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))
            dessertBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))

            tabFrom = "Breakfast Buffets"

//            breakfastBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_16sp));
//            lunchBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
//            dessertBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
        }

        lunchBuffets.setOnClickListener { v: View? ->
            breakfastBuffets.isChecked = false
            lunchBuffets.isChecked = true
            dessertBuffets.isChecked = false


            breakfastBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))
            lunchBuffets.setTextColor(requireContext().getColor(R.color.black))
            dessertBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))

            tabFrom = "Lunch Buffets"
//            breakfastBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
//            lunchBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_16sp));
//            dessertBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
        }

        dessertBuffets.setOnClickListener { v: View? ->
            breakfastBuffets.isChecked = false
            lunchBuffets.isChecked = false
            dessertBuffets.isChecked = true


            breakfastBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))
            lunchBuffets.setTextColor(requireContext().getColor(R.color.gray_dark))
            dessertBuffets.setTextColor(requireContext().getColor(R.color.black))

            tabFrom = "Dessert Buffets"
//            breakfastBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
//            lunchBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_14sp));
//            dessertBuffets.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.dimen_16sp));
        }
    }

}