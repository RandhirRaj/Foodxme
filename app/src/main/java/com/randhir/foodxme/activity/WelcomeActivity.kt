package com.randhir.foodxme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.ui.login.LoginActivity
import com.randhir.foodxme.utils.MyContextWrapper
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        prefManager = PrefManager(this)
//        Log.e("language", prefManager.language)

        textViewContinue.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        layoutLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        layoutSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    override fun attachBaseContext(base: Context) {
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(base)

        prefManager = PrefManager(base)
        if (prefManager.language.isNullOrEmpty())
            super.attachBaseContext(MyContextWrapper.wrapper(base, "en"))
        else
            super.attachBaseContext(MyContextWrapper.wrapper(base, prefManager.language!!))
    }


}