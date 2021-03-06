package com.go.arnite.ui.user.main.main

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.go.arnite.ui.user.main.BasePresenter
import com.go.arnite.ui.user.main.BaseView
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by hanilozmen on 8/24/2019.
 */
interface MainContract {
    interface Presenter: BasePresenter {
        fun onViewCreated(isRestored: Boolean)
        fun onBackPressed()
        fun onSaveInstanceState(outState: Bundle)
        fun onRestoreInstanceState(savedInstanceState: Bundle)
    }

    interface View: BaseView<Presenter> {
        fun getFragmentHolderId(): Int
        fun getMainFragmentManager(): FragmentManager
        fun getBottomNavigation(): BottomNavigationView
        fun finishActivity()
    }
}
