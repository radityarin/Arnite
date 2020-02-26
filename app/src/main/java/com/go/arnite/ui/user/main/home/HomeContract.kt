package com.go.arnite.ui.user.main.home

import com.go.arnite.ui.user.main.BasePresenter
import com.go.arnite.ui.user.main.BaseView


/**
 * Created by hanilozmen on 8/24/2019.
 */
interface HomeContract{
    interface Presenter: BasePresenter {
        fun onViewCreated()
    }

    interface View: BaseView<Presenter> {
    }
}