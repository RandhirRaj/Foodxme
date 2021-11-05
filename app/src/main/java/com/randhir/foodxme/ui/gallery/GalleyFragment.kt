package com.randhir.foodxme.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.blisbelly.restaurant.BaseFragment
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.model.gallery.GalleryData
import com.randhir.foodxme.utils.GridItemDecoration
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleyFragment : BaseFragment() {

    override fun onNetworkChange(isNetworkAvailable: Boolean) {
        TODO("Not yet implemented")
    }
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity). getSupportActionBar()?.setHomeButtonEnabled(true);
        (requireActivity() as MainActivity). getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (requireActivity() as MainActivity).toolbar.setNavigationIcon(R.drawable.ic_back);
        (requireActivity() as MainActivity).textViewActionBarName.text="Gallery"
        navController = Navigation.findNavController(view)
        (requireActivity() as MainActivity).appBarLayoutMain.visibility = View.VISIBLE
        initView()
    }

    private fun initView() {
        recyclerViewGallery.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //This will for default android divider
        recyclerViewGallery.addItemDecoration(GridItemDecoration(10, 2))

        val movieListAdapter = GalleryStaggeredAdapter()
        recyclerViewGallery.adapter = movieListAdapter
        movieListAdapter.setMovieList(generateDummyData())
    }

    private fun generateDummyData(): List<GalleryData> {
        val listOfMovie = mutableListOf<GalleryData>()

        var movieModel = GalleryData( R.drawable.soups)
        listOfMovie.add(movieModel)

        movieModel = GalleryData( R.drawable.offer_image)
        listOfMovie.add(movieModel)

        movieModel = GalleryData( R.drawable.salmon)
        listOfMovie.add(movieModel)

        movieModel = GalleryData(R.drawable.splash_screen)
        listOfMovie.add(movieModel)

        movieModel = GalleryData(R.drawable.tandoori_chicken)
        listOfMovie.add(movieModel)

        movieModel = GalleryData( R.drawable.soups)
        listOfMovie.add(movieModel)

        movieModel = GalleryData( R.drawable.splash_screen)
        listOfMovie.add(movieModel)

        return listOfMovie
    }

}