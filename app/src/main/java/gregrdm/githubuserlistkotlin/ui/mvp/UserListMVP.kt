package gregrdm.githubuserlistkotlin.ui.mvp

import gregrdm.githubuserlistkotlin.network.model.UserItem
import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import io.reactivex.Observable


/**
 *
 */

interface UserListMVP {


    interface Model {
        fun getUserList(reload: Boolean): Observable<UserItemContainer>
    }

    interface Presenter {
        fun loadUserList(reload: Boolean)
        fun clearSubscriptions()
    }

    interface View {
        fun setLoading(loading: Boolean)
        fun onUserListLoaded(userList: List<UserItem>)
    }


}