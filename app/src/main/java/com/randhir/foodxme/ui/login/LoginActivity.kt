package com.randhir.foodxme.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.randhir.foodxme.R
import com.randhir.foodxme.activity.MainActivity
import com.randhir.foodxme.api.ApiCall
import com.randhir.foodxme.api.ApiHandler
import com.randhir.foodxme.utils.PrefManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.editTextPassword
import kotlinx.android.synthetic.main.activity_login.layoutLogin
import kotlinx.android.synthetic.main.activity_login.loginBackButton
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var apiHandler: ApiHandler? = null
    val errorMsg : String? = "Can't empty"
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        prefManager = PrefManager(this)

        loginBackButton.setOnClickListener {
            this.onBackPressed()
        }

        layoutLogin.setOnClickListener {

            if (TextUtils.isEmpty(editTextEmailOrPhone.text.toString().trim()) || TextUtils.isEmpty(
                    editTextPassword.text.toString().trim()
                )
            ) {
                editTextEmailOrPhone.error = errorMsg
                editTextPassword.error = errorMsg
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editTextEmailOrPhone.text.toString().trim())) {
                editTextEmailOrPhone.error = errorMsg
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editTextPassword.text.toString().trim())) {
                editTextPassword.error = errorMsg
                return@setOnClickListener
            } else if (!TextUtils.isEmpty(
                    editTextEmailOrPhone.text.toString().trim()
                ) && !TextUtils.isEmpty(editTextPassword.text.toString().trim())
            )
                callApi()

        }

    }

    private fun callApi() {
        apiHandler = ApiHandler(this)
        apiHandler!!.login(
            editTextEmailOrPhone.text.toString().trim(),
            editTextPassword.text.toString().trim(),
            {},
            {
                prefManager.id = it?.customer?.id ?: 0
                prefManager.userFirstName = it?.customer?.firstName ?: ""
                prefManager.userLastName = it?.customer?.lastName ?: ""
                prefManager.emaiId = it?.customer?.email ?: ""
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
                Toast.makeText(this, it?.customer?.firstName, Toast.LENGTH_LONG).show()
            })

    }


}