package gregrdm.githubuserlistkotlin.ui.mvp


import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 *
 */
class UserListPresenter(val view: UserListMVP.View,
                        val model: UserListMVP.Model) : UserListMVP.Presenter {
    private var sub: Subscription? = null

    override fun loadUserList(reload: Boolean, username: String?) {
        view.setLoading(true)
        sub = model.getUserList(reload, username!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.onUserListLoaded(it.items)
                    view.setLoading(false)
                }, {
                    view.setLoading(false)
                    view.onError(it)
                })
    }

    override fun clearSubscriptions() {
        sub?.unsubscribe()
    }

}