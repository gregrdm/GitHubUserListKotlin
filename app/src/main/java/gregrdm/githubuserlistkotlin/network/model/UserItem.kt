package gregrdm.githubuserlistkotlin.network.model

import com.google.gson.annotations.SerializedName

/**
 *
 */
class UserItem {

    @SerializedName("login")
    val login: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("avatar_url")
    val avatarUrl: String? = null

    @SerializedName("gravatar_id")
    val gravatarId: String? = null

    @SerializedName("url")
    val url: String? = null

    @SerializedName("html_url")
    val htmlUrl: String? = null

    @SerializedName("followers_url")
    val followersUrl: String? = null

    @SerializedName("type")
    val type: String? = null

    @SerializedName("score")
    val score: Double? = null
}