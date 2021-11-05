package com.randhir.foodxme.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.api.ApiHandler
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_dashboard.*

class CategoriesFragment : Fragment() {

    private var apiHandler: ApiHandler? = null
    var navController: NavController? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_menu);
        (requireActivity() as MainActivity).textViewActionBarName.text="Categories"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
        (requireActivity() as MainActivity).toolbar.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white));
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        apiHandler = ApiHandler(requireContext())
        apiHandler?.categoriesList("id,name,image",{},{
            recyclerViewCategories.apply {
                layoutManager = LinearLayoutManager(context)

                adapter = CategoriesAdapter(it?.category!!).apply {
                    setClickLisner {
                        it?.let { it1 ->
                            navController?.navigate(CategoriesFragmentDirections.actionNavigationDashboardToProductFragment(it1))
                        }
                    }
                }

//                adapter = CategoriesAdapter(it).apply { setClickLisner {
//                    it?.let {
//                        it1->navController.navigate(ProductFragment.action_navigation_dashboard_to_productFragment)
//                    }
//                } })

            }
            Log.e("id,name,image",it?.category.toString())
        })
    }
}