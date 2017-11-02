package gregrdm.githubuserlistkotlin.ui.mvp

import gregrdm.githubuserlistkotlin.network.model.UserItem
import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import rx.Observable


/**
 *
 */

interface UserListMVP {


    interface Model {
        fun getUserList(reload: Boolean): Observable<UserItemContainer>
    }

    interface Presenter {
        fun loadUserList(reload: Boolean, username: String?)
        fun clearSubscriptions()
    }

    interface View {
        fun setLoading(loading: Boolean)
        fun onUserListLoaded(userList: List<UserItem>)
        fun onError(throwable: Throwable?)
    }


}