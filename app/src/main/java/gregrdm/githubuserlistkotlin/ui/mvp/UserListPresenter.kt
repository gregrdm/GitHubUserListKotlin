package gregrdm.githubuserlistkotlin.ui.mvp


import gregrdm.githubuserlistkotlin.utils.SchedulersImpl
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject


/**
 *
 */

class UserListPresenter
@Inject constructor(val view: UserListMVP.View, val model: UserListMVP.Model, val schedulers: SchedulersImpl) : UserListMVP.Presenter {
    private var sub: Subscription? = null

    override fun loadUserList(reload: Boolean, username: String?) {
        view.setLoading(true)

        sub = model.getUserList(reload, username!!)
                .subscribeOn(schedulers.subscriber)
                .observeOn(schedulers.observer)
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