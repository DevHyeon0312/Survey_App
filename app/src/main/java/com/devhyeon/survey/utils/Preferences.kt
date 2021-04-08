package com.devhyeon.survey.utils

import android.content.Context
import android.content.SharedPreferences
import com.devhyeon.survey.SHARED_PREFERENCES_FILE_NAME

fun getPreferencesString(context: Context, key: String , defaultValue: String) : String {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    return pref.getString(key, defaultValue).toString()
}
fun getPreferencesBoolean(context: Context, key: String , defaultValue: Boolean) : Boolean {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    return pref.getBoolean(key, defaultValue)
}
fun getPreferencesFloat(context: Context, key: String , defaultValue: Float) : Float {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    return pref.getFloat(key, defaultValue)
}
fun getPreferencesInt(context: Context, key: String , defaultValue: Int) : Int {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    return pref.getInt(key, defaultValue)
}
fun getPreferencesLong(context: Context, key: String , defaultValue: Long) : Long {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    return pref.getLong(key,defaultValue)
}

fun setPreferencesString(context: Context, key: String, value: String) {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    pref.edit().putString(key, value).apply()
}
fun setPreferencesBoolean(context: Context, key: String, value: Boolean) {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    pref.edit().putBoolean(key, value).apply()
}
fun setPreferencesFloat(context: Context, key: String, value: Float) {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    pref.edit().putFloat(key, value).apply()
}
fun setPreferencesInt(context: Context, key: String, value: Int) {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    pref.edit().putInt(key, value).apply()
}
fun setPreferencesLong(context: Context, key: String, value: Long) {
    val pref : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    pref.edit().putLong(key, value).apply()
}