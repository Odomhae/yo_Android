package com.odom.yo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.odom.yo.adapter.UserRvAdapter
import com.odom.yo.model.UserItem
import com.odom.yo.model.UserResult
import com.odom.yo.util.MyFunctions
import com.odom.yo.util.UserClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var retrofitInterface = UserClient().mGetApi
    private lateinit var userResult : List<UserItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        jobGetInfo().onJoin
    }

    private fun jobGetInfo() = CoroutineScope(Dispatchers.IO).launch {

        try {
            retrofitInterface.getUserInfo("shop").enqueue(object : retrofit2.Callback<UserResult>{
                override fun onResponse(call: Call<UserResult>, response: Response<UserResult>) {
                    if(response.isSuccessful){
                        userResult = response.body()?.items!!
                        rv_users.adapter = UserRvAdapter(this@MainActivity, userResult)
                    }
                }

                override fun onFailure(call: Call<UserResult>, t: Throwable) {
                    Log.d("===onFailure",  "failure")
                }
            })


        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}