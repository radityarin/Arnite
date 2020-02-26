package com.go.arnite.ui.user.main.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.go.arnite.R
import com.go.arnite.ui.user.main.BaseActivity
import com.go.arnite.ui.user.main.history.HistoryPresenter
import com.go.arnite.ui.user.main.home.HomePresenter
import com.go.arnite.ui.user.main.inbox.InboxPresenter
import com.go.arnite.ui.user.main.profile.ProfilePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_main_user.*

/**
 * Created by hanilozmen on 8/24/2019.
 */
class MainUserActivity : BaseActivity(), MainContract.View {

    private var mPresenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)

        attachPresenter(MainPresenter(this))
        mPresenter?.onViewCreated(savedInstanceState != null)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mPresenter?.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPresenter?.onRestoreInstanceState(savedInstanceState)

    }

    override fun onDestroy() {
        detachPresenter()
        super.onDestroy()
    }

    override fun onBackPressed() {
        mPresenter?.onBackPressed()
    }

    override fun attachPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun finishActivity() {
        finish()
    }

    override fun getMainFragmentManager(): FragmentManager = supportFragmentManager

    override fun getFragmentHolderId(): Int = R.id.container_main

    override fun getBottomNavigation(): BottomNavigationView = view_navigation

    override fun showProgress() {}

    override fun hideProgress() {}


}
