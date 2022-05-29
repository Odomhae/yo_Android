package com.odom.yo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResult {

    @SerializedName("items")
    @Expose
    var items: List<UserItem>? = null

}