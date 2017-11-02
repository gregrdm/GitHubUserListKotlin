package gregrdm.githubuserlistkotlin.ui.mvp

import gregrdm.githubuserlistkotlin.network.UserQueryApi
import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import io.reactivex.Observable

/**
 *
 */

class UserListModel(val userQueryApi: UserQueryApi): UserListMVP.Model {
    override fun getUserList(reload: Boolean): Observable<UserItemContainer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}