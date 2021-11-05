package com.randhir.foodxme.activity

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.randhir.foodxme.R
import com.randhir.foodxme.utils.MyContextWrapper
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.menu_item.*

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var layoutCloseDrawable: ImageView
    lateinit var drawerLayout: DrawerLayout
    lateinit var textViewActionBarName: TextView
    lateinit var layoutCart: ImageView
    lateinit var layoutYourOrder: ConstraintLayout
    lateinit var layoutFoodCaterings: ConstraintLayout
    lateinit var layoutFoodEvents: ConstraintLayout
    lateinit var layoutFoodBookings: ConstraintLayout
    lateinit var layoutOthersCoupons: ConstraintLayout
    lateinit var textViewGallery: ConstraintLayout
    lateinit var layoutOthersInviteFriends: ConstraintLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var prefManager: PrefManager

    companion object {
        const val RECORD_REQUEST_CODE = 101
        const val ACTION_NETWORK_CHANGE = "action.NETWORK_CHANGE"
        const val EXTRA_CONNECTION_STATE = "extra.CONNECTION_STATE"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefManager = PrefManager(this)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navigationView)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfigurationNew = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_categories,
                R.id.favouriteOrderFragment,
                R.id.hotSaleFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfigurationNew)
        bottomNavigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_categories,
                R.id.favouriteOrderFragment,
                R.id.hotSaleFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        layoutCart = findViewById(R.id.layoutCart)
        textViewActionBarName = findViewById(R.id.textViewActionBarName)

        layoutCloseDrawable = findViewById(R.id.layoutCloseDrawable)
        layoutYourOrder = findViewById(R.id.layoutYourOrder)
        layoutFoodCaterings = findViewById(R.id.layoutFoodCaterings)
        layoutFoodEvents = findViewById(R.id.layoutFoodEvents)
        layoutFoodBookings = findViewById(R.id.layoutFoodBookings)
        layoutOthersCoupons = findViewById(R.id.layoutOthersCoupons)
        textViewGallery = findViewById(R.id.layoutOthersGallery)
        layoutOthersInviteFriends = findViewById(R.id.layoutOthersInviteFriends)

        if (prefManager.userFirstName != null)
            textViewUserName.text = prefManager.userFirstName + " " + prefManager.userLastName
        else
            textViewUserName.text = "Gest"

        if (prefManager.emaiId!=null)
            textViewUserEmail.text=prefManager.emaiId

        layoutFavouriteOrder.setOnClickListener {
            navController.navigate(R.id.favouriteOrderFragment)
            drawerLayout.close()
        }

//        textViewGallery.setOnClickListener {
//            navController.navigate(R.id.galleyFragment)
//            drawerLayout.close()
//        }

        layoutCloseDrawable.setOnClickListener {
            drawerLayout.close()
        }

        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_menu);

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun attachBaseContext(base: Context) {
        prefManager = PrefManager(base)
        if (PrefManager(base).language.isNullOrEmpty())
            super.attachBaseContext(MyContextWrapper.wrapper(base, "en"))
        else
            super.attachBaseContext(MyContextWrapper.wrapper(base, prefManager.language!!))

    }


//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId==android.R.id.home)
////            Toast.makeText(this,)
//
//        return super.onOptionsItemSelected(item)
//
//    }
}