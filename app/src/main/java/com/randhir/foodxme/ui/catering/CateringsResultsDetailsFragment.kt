package com.randhir.foodxme.ui.catering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_details.*

class CateringsResultsDetailsFragment : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    private val arg: CateringsResultsDetailsFragmentArgs by navArgs()
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_caterings_results_details, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewActionBarName.text = arg.FromTab

        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.GONE

        imageViewBack.setOnClickListener() {
            requireActivity().onBackPressed()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
    }


}