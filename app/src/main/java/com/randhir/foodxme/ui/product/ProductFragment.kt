package com.randhir.foodxme.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.api.ApiHandler
import com.randhir.foodxme.model.product.ProductMenu
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_product.*
import org.json.JSONObject

class ProductFragment : BaseFragment() {

    private var apiHandler: ApiHandler? = null
    private val args: ProductFragmentArgs by navArgs()

    var productMenu: ProductMenu? = null
    val menuItem = ArrayList<ProductMenu>()


    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_product, container, false)
        Toast.makeText(requireContext(), args.Id.toString(), Toast.LENGTH_LONG).show()
//        (requireActivity() as MainActivity).textViewAppTitle.text = getString(R.string.available)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (requireActivity() as MainActivity).toolbar?.setNavigationIcon(R.drawable.ic_back);
        (requireActivity() as MainActivity).textViewActionBarName.text = "Menu"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in 0..5) {
            if (i == 0) {
                productMenu = ProductMenu("Meat", false)
                menuItem.add(productMenu!!)
            }
            if (i == 1) {
                productMenu = ProductMenu("Chicken", false)
                menuItem.add(productMenu!!)
            }
            if (i == 2) {
                productMenu = ProductMenu("Sea food", false)
                menuItem.add(productMenu!!)
            }
            if (i == 3) {
                productMenu = ProductMenu("Vegetarian", false)
                menuItem.add(productMenu!!)
            }
            if (i == 4) {
                productMenu = ProductMenu("Most selling", false)
                menuItem.add(productMenu!!)

            }
        }

        recyclerViewMainCourse.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewMainCourse.adapter = ProductMenuAdapter(menuItem)

        apiHandler = ApiHandler(requireContext())
        apiHandler?.productsList(args.Id, {

            val json: JSONObject = JSONObject(it)
            val jsonNew: JSONObject = JSONObject(json.getString("responsemsg"))

            Toast.makeText(requireContext(), jsonNew.getString("ResponseResult"),Toast.LENGTH_LONG).show()

        }, {
            if (!it?.message.equals("failure")){
                recyclerViewProduct.apply {
                    layoutManager = LinearLayoutManager(context)
//                adapter= ProductAdapter(it?.products)
                    adapter = ProductAdapter(it?.products).apply {
                        setClickLisner {
                            it?.let { it1 ->
                                navController?.navigate(
                                    ProductFragmentDirections.actionProductFragmentToProductDetails(
                                        it1
                                    )
                                )
                            }
                        }
                    }
                }
            }


            Log.e("id,name,image", it?.products.toString())
        })
    }

}