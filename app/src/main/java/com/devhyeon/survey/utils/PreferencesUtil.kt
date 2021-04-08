package com.devhyeon.survey.utils

import android.content.Context
import android.content.SharedPreferences
import com.devhyeon.survey.SHARED_PREFERENCES_FILE_NAME

/**
 * 이 클래스는 SharedPreferences 를 사용하여 get, set 을 구혀한 클래스입니다.
 * */
class PreferencesUtil(context : Context) {
    private val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)

    fun getString(key: String , defaultValue: String) : String {
        return pref.getString(key, defaultValue).toString()
    }
    fun getBoolean(key: String , defaultValue: Boolean) : Boolean {
        return pref.getBoolean(key, defaultValue)
    }
    fun getFloat(key: String , defaultValue: Float) : Float {
        return pref.getFloat(key, defaultValue)
    }
    fun getInt(key: String , defaultValue: Int) : Int {
        return pref.getInt(key, defaultValue)
    }
    fun getLong(key: String , defaultValue: Long) : Long {
        return pref.getLong(key,defaultValue)
    }

    fun setString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }
    fun setBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }
    fun setFloat(key: String, value: Float) {
        pref.edit().putFloat(key, value).apply()
    }
    fun setInt(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }
    fun setLong(key: String, value: Long) {
        pref.edit().putLong(key, value).apply()
    }
}