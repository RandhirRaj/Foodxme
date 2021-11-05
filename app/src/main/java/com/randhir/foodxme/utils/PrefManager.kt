package com.randhir.foodxme.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


class PrefManager(private val context: Context) {
    companion object {
        const val PREFERENCE_NAME: String = "FoodApp"
        const val MOBILE: String = "mobile"
        const val TOKEN: String = "token"
        const val LANGUAGE: String = "language"
        const val FIRST_NAME: String = "userFirstName"
        const val LAST_NAME: String = "userLastName"
        const val EMAI_ID: String = "userEmailId"
        const val ID: String = "id"
    }

    /*
    * Create shared preference
    */
    private val preference: SharedPreferences
        get() = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    /*
     * Creates Shared Preference Editor object for editing preference values
     */
    private val editor: SharedPreferences.Editor
        @SuppressLint("CommitPrefEdits") get() = preference.edit()

    var mobile: String?
        get() = preference.getString(MOBILE, null)
        set(value) {
            editor.putString(MOBILE, value).apply()
        }

    var token: String?
        get() = preference.getString(TOKEN, null)
        set(value) {
            editor.putString(TOKEN, value).apply()
        }

    var userFirstName: String?
        get() = preference.getString(FIRST_NAME, null)
        set(value) {
            editor.putString(FIRST_NAME, value).apply()
        }

    var userLastName: String?
        get() = preference.getString(LAST_NAME, null)
        set(value) {
            editor.putString(LAST_NAME, value).apply()
        }

    var emaiId: String?
        get() = preference.getString(EMAI_ID, null)
        set(value) {
            editor.putString(EMAI_ID, value).apply()
        }

    var language: String?
        get() = preference.getString(LANGUAGE, null)
        set(value) {
            editor.putString(LANGUAGE, value).apply()
        }

    var id: Int
        get() = preference.getInt(ID, 0)
        set(value) {
            editor.putInt(ID, value).apply()
        }

    fun clear() {
        preference.edit().clear().apply()
    }

}