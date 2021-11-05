package com.randhir.foodxme.ui.toppick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.ui.home.toppick.HomeTopPickAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_top_pick.recyclerViewTopPick

class TopPickFragment : BaseFragment() {
    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }

    private val args: TopPickFragmentArgs by navArgs()
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_top_pick, container, false)
        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireActivity() as MainActivity).getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back);
        (requireActivity() as MainActivity).textViewActionBarName.text = "Top Pick"
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        recyclerViewTopPick.apply {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            adapter = HomeTopPickAdapter(args.topPick.products).apply {
                setClickLisner {
                    it?.let { it1 ->
                        navController?.navigate(TopPickFragmentDirections.actionTopPickFragmentToProductDetails(it1))
                    }
                }
            }
        }
    }
}

