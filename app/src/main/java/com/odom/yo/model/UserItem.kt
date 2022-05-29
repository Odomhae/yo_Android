package com.odom.yo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserItem {

    @SerializedName("login")
    @Expose
    var login: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
}