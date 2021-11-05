package com.randhir.foodxme.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randhir.foodxme.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        loginBackButton.setOnClickListener {
            this.onBackPressed()
        }


    }
}