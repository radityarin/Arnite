package com.go.arnite.ui.user.main.history

import android.os.Bundle
import com.go.arnite.ui.user.main.BaseFragment
import com.go.arnite.ui.user.main.util.FragMan

/**
 * Created by hanilozmen on 8/24/2019.
 */
class HistoryPresenter(var mView: HistoryContract.View?) :
    HistoryContract.Presenter {

    companion object{
        const val KEY_TITLE: String = "KEY_TITLE"
        fun newInstance(args: Bundle? = null): BaseFragment {
            val fragment = HistoryFragment()
            args?.let { fragment.arguments = it }
            return fragment
        }
    }

    override fun onViewCreated() {
    }

    override fun onDestroy() {
        mView = null
    }

}