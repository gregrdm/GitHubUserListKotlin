package gregrdm.githubuserlistkotlin.ui.mvp

import gregrdm.githubuserlistkotlin.network.UserQueryApi
import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import rx.Observable


/**
 *
 */

class UserListModel(val userQueryApi: UserQueryApi): UserListMVP.Model {
    override fun getUserList(reload: Boolean, username: String): Observable<UserItemContainer> =
            userQueryApi.getUsers(username).map { it }

}