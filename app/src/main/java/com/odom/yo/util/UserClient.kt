package com.odom.yo.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserClient {

    private val baseUrl = "https://api.github.com"
    val mGetApi: UserApi

    init {
        val mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mGetApi = mRetrofit.create(UserApi::class.java)
    }
}