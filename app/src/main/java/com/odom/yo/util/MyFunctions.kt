package com.odom.yo.util

import android.content.Context
import android.widget.ImageButton

class MyFunctions(private val context: Context) {

    fun clickLike(imageButton: ImageButton, id :Int){

        val items = ArrayList<Int>()
        val listPref = PreferenceSetting(context).clickList
        if(listPref.size > 0){
            for (value in listPref)
                items.add(value)
        }

        if(imageButton.isSelected){
            // uncheck
            imageButton.isSelected = false

            // remove from list
            items.remove(id)
            PreferenceSetting(context).clickList = items

        }else{
            // uncheck
            imageButton.isSelected = true

            // add to list
            items.add(id)
            PreferenceSetting(context).clickList = items
        }

    }


    fun checkLike(id : Int) : Boolean{
        val clickList = PreferenceSetting(context).clickList
        if(clickList.size > 0){
            for(i in 0 until clickList.size){
                if (clickList[i] == id){
                    return true
                }
            }
        }

        return false
    }
}