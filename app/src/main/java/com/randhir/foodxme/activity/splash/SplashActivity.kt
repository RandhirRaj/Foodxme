package com.rst.cashit.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.activity.LanguageSelectActivity
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.utils.MyContextWrapper
import com.randhir.foodxme.utils.MyContextWrapperJava.wrapper
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 2000
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        prefManager = PrefManager(this)

//        textViewLogin.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finishAffinity()
//        }

//        textViewContinue.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//            finishAffinity()
//        }

        Handler().postDelayed({
            if (prefManager.id==0)
            startActivity(Intent(this, LanguageSelectActivity::class.java))
            else
                startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MyContextWrapper.wrapper(base,"ar"))

    }
}