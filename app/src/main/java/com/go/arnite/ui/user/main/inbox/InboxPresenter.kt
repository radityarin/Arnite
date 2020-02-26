package com.go.arnite.ui.user.main.inbox

import android.os.Bundle
import com.go.arnite.ui.user.main.BaseFragment

/**
 * Created by hanilozmen on 8/24/2019.
 */
class InboxPresenter(var mView: InboxContract.View?) :
    InboxContract.Presenter {

    companion object{
        const val KEY_TITLE: String = "KEY_TITLE"
        fun newInstance(args: Bundle? = null): BaseFragment {
            val fragment = InboxFragment()
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