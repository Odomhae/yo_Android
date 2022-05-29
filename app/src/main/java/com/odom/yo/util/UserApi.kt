package com.odom.yo.util

import com.odom.yo.model.UserResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("https://api.github.com/search/users")
    fun getUserInfo(
        @Query("q") q: String?

        ): Call<UserResult>
}