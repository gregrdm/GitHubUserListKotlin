package gregrdm.githubuserlistkotlin.ui.mvp

import gregrdm.githubuserlistkotlin.network.model.UserItem
import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import gregrdm.githubuserlistkotlin.utils.SchedulersImpl
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import rx.Scheduler
import rx.android.plugins.RxAndroidPlugins
import rx.android.plugins.RxAndroidSchedulersHook
import rx.plugins.RxJavaHooks
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject


/**
 *
 */
class UserListPresenterTest {

    @Mock lateinit var view: UserListMVP.View
    @Mock lateinit var model: UserListMVP.Model

    lateinit var presenter: UserListPresenter

    val subject: PublishSubject<UserItemContainer> = PublishSubject.create()
    val schedulers = SchedulersImpl(Schedulers.immediate(), Schedulers.immediate())
    val dummyUserList = dummyUserItemContainer()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        overrideSchedulers()


        Mockito.`when`(model.getUserList(false, "gregrdm")).thenReturn(subject)
        presenter = UserListPresenter(view, model, schedulers)
    }

    @Test
    fun shouldLoadUserItemInfo() {

        presenter.loadUserList(false, "gregrdm")
        subject.onNext(dummyUserList)


        Mockito.verify(view).onUserListLoaded(dummyUserList.items)
    }

    private fun dummyUserItemContainer() : UserItemContainer {
        val userItemContainer = UserItemContainer()
        userItemContainer.totalCount = 1
        userItemContainer.isIncompleteResults = false
        userItemContainer.items = listOf(UserItem("gregrdm",0,"","","","","","User",24.5))
        return userItemContainer
    }

    private fun overrideSchedulers() {
        // Override RxJava schedulers
        RxJavaHooks.setOnIOScheduler { Schedulers.immediate() }

        RxJavaHooks.setOnComputationScheduler { Schedulers.immediate() }

        RxJavaHooks.setOnNewThreadScheduler { Schedulers.immediate() }

        // Override RxAndroid schedulers
        val rxAndroidPlugins = RxAndroidPlugins.getInstance()
        rxAndroidPlugins.registerSchedulersHook(object : RxAndroidSchedulersHook() {
            override fun getMainThreadScheduler(): Scheduler {
                return Schedulers.immediate()
            }
        })
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        RxJavaHooks.reset()
        RxAndroidPlugins.getInstance().reset()
    }

}