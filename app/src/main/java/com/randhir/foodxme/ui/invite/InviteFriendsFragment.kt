package com.randhir.foodxme.ui.invite

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

class InviteFriendsFragment : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_invite_friends, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back)
        (requireActivity() as MainActivity).textViewActionBarName.text = "Invite Friends"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
        (requireActivity() as MainActivity).layoutCart.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as MainActivity).layoutCart.visibility = View.VISIBLE
    }

}