package com.randhir.foodxme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.utils.MyContextWrapper
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.activity_language.*
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash.textViewContinue

class LanguageSelectActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        prefManager = PrefManager(this)

        layoutLanguageEnglish.setOnClickListener {
            prefManager.language="en"?: "en"
            startActivity(Intent(this, WelcomeActivity::class.java))
            finishAffinity()
        }

        layoutLanguageArabic.setOnClickListener {
            prefManager.language="ar"?: "en"
            startActivity(Intent(this, WelcomeActivity::class.java))
            finishAffinity()
        }

    }



}