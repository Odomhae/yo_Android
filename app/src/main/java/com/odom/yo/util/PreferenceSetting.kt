package com.odom.yo.util

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

class PreferenceSetting(context : Context) {

    private val prefs : SharedPreferences by lazy {
        context.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
    }

    var clickList : ArrayList<Int>
        get() {
            val listString = prefs.getString("clickList", null)
            val userList = ArrayList<Int>()

            try {
                val jsonArray =  JSONArray(listString)
                for (i in 0 until jsonArray.length()) {
                    val stuff = jsonArray.optInt(i) // getInt
                    userList.add(stuff)
                }

            }catch (e:Exception){
                e.printStackTrace()
            }

            return userList
        }

        set(value) = prefs.edit().putString("clickList", value.toString()).apply()

}