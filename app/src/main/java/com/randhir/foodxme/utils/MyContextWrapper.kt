package com.randhir.foodxme.utils

import android.annotation.TargetApi
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.os.Build
import com.randhir.foodxme.utils.MyContextWrapperJava.*
import java.util.*

class MyContextWrapper(base: Context?) : ContextWrapper(base) {

    companion object {
        fun wrapper(context: Context, language: String): ContextWrapper? {
            var context = context
            val configuration = context.resources.configuration
            var sysLocal: Locale? = null
            sysLocal = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                getSystemLocale(configuration)
            } else {
                getSystemLocaleLegacy(configuration)
            }
            if (language != "" && sysLocal!!.language != language) {
                val locale = Locale(language)
                Locale.setDefault(locale)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    setSystemSystemLocale(configuration, locale)
                } else {
                    setSystemLocaleLegacy(configuration, locale)
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context = context.createConfigurationContext(configuration)
            } else {
                context.resources.updateConfiguration(
                    configuration,
                    context.resources.displayMetrics
                )
            }
            return MyContextWrapperJava(context)
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun getSystemLocale(configuration: Configuration): Locale? {
        return configuration.locales[0]
    }

    fun getSystemLocaleLegacy(configuration: Configuration): Locale? {
        return configuration.locale
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun setSystemSystemLocale(configuration: Configuration, locale: Locale?) {
        configuration.setLocale(locale)
    }

    fun setSystemLocaleLegacy(configuration: Configuration, locale: Locale?) {
        configuration.setLocale(locale)
    }
}