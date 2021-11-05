package com.randhir.foodxme.model.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.api.ApiHandler
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_details.*


class ProductDetails : BaseFragment() {

    private var apiHandler: ApiHandler? = null
    private val args: ProductDetailsArgs by navArgs()

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_details, container, false)
        Toast.makeText(requireContext(), args.Id.toString(), Toast.LENGTH_LONG).show()
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.GONE
        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewBack.setOnClickListener() {
            requireActivity().onBackPressed()
        }
//        (requireActivity() as MainActivity).toolbar?.setNavigationIcon(R.drawable.ic_back);
//        (requireActivity() as MainActivity).toolbar.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.transparent));
    }

}