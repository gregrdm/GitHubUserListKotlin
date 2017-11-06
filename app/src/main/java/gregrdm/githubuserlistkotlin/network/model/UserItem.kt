package gregrdm.githubuserlistkotlin.network.model

import com.google.gson.annotations.SerializedName

/**
 *
 */
class UserItem {

    @SerializedName("login")
    var login: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("avatar_url")
    var avatarUrl: String? = null

    @SerializedName("gravatar_id")
    var gravatarId: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("html_url")
    var htmlUrl: String? = null

    @SerializedName("followers_url")
    var followersUrl: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("score")
    var score: Double? = null

    constructor(login: String?, id: Int?, avatarUrl: String?, gravatarId: String?, url: String?, htmlUrl: String?, followersUrl: String?, type: String?, score: Double?) {
        this.login = login
        this.id = id
        this.avatarUrl = avatarUrl
        this.gravatarId = gravatarId
        this.url = url
        this.htmlUrl = htmlUrl
        this.followersUrl = followersUrl
        this.type = type
        this.score = score
    }
}