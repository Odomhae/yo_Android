package com.odom.yo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odom.yo.DetailActivity
import com.odom.yo.R
import com.odom.yo.model.UserItem
import com.odom.yo.util.MyFunctions

class UserRvAdapter(private var context: Context, private var listUser : List<UserItem>?)
    : RecyclerView.Adapter<UserRvAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userPhoto : ImageView = itemView.findViewById(R.id.user_photo)
        val userName : TextView = itemView.findViewById(R.id.user_name)
        val userDescription : TextView = itemView.findViewById(R.id.user_description)
        val userLike : ImageButton = itemView.findViewById(R.id.user_like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if(listUser != null){

            holder.apply {
                Glide.with(context).load(listUser!![position].avatarUrl)
                    .override(50, 150)
                    .into(userPhoto)

                userName.text = listUser!![position].login
                userDescription.text = listUser!![position].htmlUrl
                userLike.isSelected = MyFunctions(context).checkLike(listUser!![position].id!!)
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("photo", listUser!![holder.adapterPosition].avatarUrl)
            intent.putExtra("name", holder.userName.text)
            intent.putExtra("description", holder.userDescription.text)
            intent.putExtra("id", listUser!![holder.adapterPosition].id)

            context.startActivity(intent)
        }

        holder.userLike.setOnClickListener {
            MyFunctions(context).clickLike(holder.userLike, listUser!![holder.adapterPosition].id!!.toInt())
        }
    }


    override fun getItemCount() = listUser!!.size
}