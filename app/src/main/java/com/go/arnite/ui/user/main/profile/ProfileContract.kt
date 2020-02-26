package com.go.arnite.ui.user.main.profile

import com.go.arnite.ui.user.main.BasePresenter
import com.go.arnite.ui.user.main.BaseView


/**
 * Created by hanilozmen on 8/24/2019.
 */
interface ProfileContract {


    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun addFragment()
        fun logOut()
    }

    interface View :
        BaseView<Presenter> {
        fun onLogoutSuccess(message: String)

        fun onLogoutFailure(message: String)
    }
}