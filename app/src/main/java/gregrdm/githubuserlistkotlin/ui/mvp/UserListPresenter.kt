package gregrdm.githubuserlistkotlin.ui.mvp

import rx.Subscription


/**
 *
 */
class UserListPresenter(val view: UserListMVP.View,
                        val model: UserListMVP.Model) : UserListMVP.Presenter {
    private var sub: Subscription? = null

    override fun loadUserList(reload: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearSubscriptions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}