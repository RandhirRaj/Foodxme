package com.randhir.foodxme.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;

import java.util.Locale;

public class MyContextWrapperJava extends ContextWrapper {

    public MyContextWrapperJava(Context base) {
        super(base);
    }

    public static ContextWrapper wrapper(Context context,String language){

        Configuration configuration =  context.getResources().getConfiguration();
        Locale sysLocal= null;
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
            sysLocal = getSystemLocale(configuration);
        }else {
            sysLocal = getSystemLocaleLegacy(configuration);
        }

        if (!language.equals("")&&!sysLocal.getLanguage().equals(language)){

            Locale locale=new Locale(language);
            Locale.setDefault(locale);
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                setSystemSystemLocale(configuration,locale);
            }else {
                setSystemLocaleLegacy(configuration,locale);
            }
        }

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            context = context.createConfigurationContext(configuration);
        }else {
            context.getResources().updateConfiguration(configuration,context.getResources().getDisplayMetrics());
        }
        return new MyContextWrapperJava(context);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public static Locale getSystemLocale(Configuration configuration){
        return configuration.getLocales().get(0);
    }

    @SuppressWarnings("deprecation")
    public static Locale getSystemLocaleLegacy(Configuration configuration){
        return configuration.locale;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public static void setSystemSystemLocale(Configuration configuration,Locale locale){
        configuration.setLocale(locale);
    }

    @SuppressWarnings("deprecation")
    public static void setSystemLocaleLegacy(Configuration configuration,Locale locale){
        configuration.setLocale(locale);
    }

}
