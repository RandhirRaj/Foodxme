package com.randhir.foodxme.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.api.ApiHandler
import com.randhir.foodxme.model.bestsellers.Bestsellers
import com.randhir.foodxme.ui.home.toppick.HomeTopPickAdapter
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var apiHandler: ApiHandler? = null
    var navController: NavController? = null
    var listBestsellers: Bestsellers? = null
    private lateinit var prefManager: PrefManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        (requireActivity() as MainActivity).getSupportActionBar()
            ?.setHomeAsUpIndicator(R.drawable.ic_menu);
        prefManager = PrefManager(requireContext())
        (requireActivity() as MainActivity).textViewActionBarName.text = ""
        (requireActivity() as MainActivity).toolbar.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
//        (requireActivity() as MainActivity).toolbar.title = prefManager.userFirstName!!
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).layoutCart.visibility = View.VISIBLE
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
        if (prefManager.userFirstName!=null)
        (requireActivity() as MainActivity).textViewActionBarName.text = prefManager.userFirstName + " " + prefManager.userLastName
        else
            (requireActivity() as MainActivity).textViewActionBarName.text=getString(R.string.app_name)
        Log.e("savedInstanceState", savedInstanceState.toString())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        textViewSearchHome.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToSearchFragment())
        }

        (requireActivity() as MainActivity).layoutYourOrder.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToOrderFragment())
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        (requireActivity() as MainActivity).layoutFoodCaterings.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToCateringsFragment())
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        (requireActivity() as MainActivity).layoutOthersCoupons.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToCouponsFragments())
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        (requireActivity() as MainActivity).layoutOthersInviteFriends.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToInviteFriendsFragment())
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        (requireActivity() as MainActivity).textViewGallery.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToGalleyFragment())
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        layoutStarters.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToProductFragment("1"))
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        layoutSoups.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToProductFragment("24"))
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        layoutMainCourse.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToProductFragment("23"))
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        layoutDesserts.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToProductFragment("25"))
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        layoutDrink.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToProductFragment("22"))
            (requireActivity() as MainActivity).drawerLayout.close()
        }

        textViewTopPickButton.setOnClickListener {
            if (listBestsellers != null) {
                navController?.navigate(
                    HomeFragmentDirections.actionNavigationHomeToTopPickFragment(
                        listBestsellers!!
                    )
                )
            }

        }

        (requireActivity() as MainActivity).layoutCart.setOnClickListener {
            navController!!.navigate(HomeFragmentDirections.actionNavigationHomeToCartFragment())
        }

        apiHandler = ApiHandler(requireContext())
        apiHandler?.bestsSellersList({}, {
            listBestsellers = it
            recyclerViewTopPick.apply {
                layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
                adapter = HomeTopPickAdapter(it?.products).apply {
                    setClickLisner {
                        it?.let { it1 ->
                            navController?.navigate(
                                HomeFragmentDirections.actionNavigationHomeToProductDetails(
                                    it1
                                )
                            )
                        }
                    }
                }
            }
            Log.e("id,name,image", it?.products.toString())
        })
    }
}