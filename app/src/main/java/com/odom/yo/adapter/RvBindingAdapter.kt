package com.odom.yo.adapter

import android.content.Intent
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.odom.yo.DetailActivity
import com.odom.yo.util.MyFunctions

object RvBindingAdapter {

    @BindingAdapter("setPhoto")
    @JvmStatic
    fun setPhoto(imageView: ImageView, url: String){

        Glide.with(imageView.context).load(url)
            .override(50, 150)
            .into(imageView)
    }

    @BindingAdapter("setClick")
    @JvmStatic
    fun setClick(imageButton: ImageButton, id: Int){
        imageButton.isSelected = MyFunctions(imageButton.context).checkLike(id)
    }

}