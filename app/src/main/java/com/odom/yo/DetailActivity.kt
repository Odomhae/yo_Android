package com.odom.yo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.odom.yo.util.MyFunctions
import com.odom.yo.util.PreferenceSetting
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photoUrl = intent.getStringExtra("photo")
        Glide.with(this).load(photoUrl)
            .override(150, 150)
            .into(detail_photo)

        detail_name.text = intent.getStringExtra("name")
        detail_description.text = intent.getStringExtra("description")
        detail_like.isSelected = intent.getBooleanExtra("like", false)

        val id = intent.getIntExtra("id", 0)
        detail_like.isSelected = MyFunctions(this).checkLike(id)
        detail_like.setOnClickListener {
            MyFunctions(this).clickLike(detail_like, id)
        }
    }
}