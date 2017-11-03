package gregrdm.githubuserlistkotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import gregrdm.githubuserlistkotlin.App
import gregrdm.githubuserlistkotlin.R
import gregrdm.githubuserlistkotlin.network.model.UserItem
import gregrdm.githubuserlistkotlin.ui.adapter.UserListRecyclerViewAdapter
import gregrdm.githubuserlistkotlin.ui.dagger.DaggerUserListComponent
import gregrdm.githubuserlistkotlin.ui.dagger.UserListModule
import gregrdm.githubuserlistkotlin.ui.mvp.UserListMVP
import gregrdm.githubuserlistkotlin.ui.mvp.UserListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserListActivity : AppCompatActivity(), UserListMVP.View {

    @Inject lateinit var presenter: UserListPresenter
    private var adapter: UserListRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inject()

        adapter = UserListRecyclerViewAdapter(emptyList())
        recycler_view.setAdapter(adapter)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.setLayoutManager(layoutManager)

        val txtsearch = findViewById(R.id.text_input_edit_text) as EditText
        txtsearch.setOnTouchListener(View.OnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= txtsearch.getRight() - txtsearch.getTotalPaddingRight()) {
                    presenter.loadUserList(true, text_input_edit_text.text.toString().trim())
                    return@OnTouchListener true
                }
            }
            false
        })

    }

    private fun inject() {
        DaggerUserListComponent.builder()
                .netComponent((applicationContext as App).netComponent)
                .userListModule(UserListModule(this))
                .build().inject(this)
    }

    override fun setLoading(loading: Boolean) {
        if (loading)
            progress_bar.visibility = View.VISIBLE
        else {
            progress_bar.visibility = View.GONE
        }
    }

    override fun onUserListLoaded(userList: List<UserItem>) {
        adapter?.setItems(userList)
    }

    override fun onError(throwable: Throwable?) {
        Toast.makeText(this, "Error occured!\nLogged, check the logcat", Toast.LENGTH_SHORT).show()
        Log.d("ERROR", throwable?.message)
    }
}
