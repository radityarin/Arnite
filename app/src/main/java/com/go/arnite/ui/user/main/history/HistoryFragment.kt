package com.go.arnite.ui.user.main.history
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.go.arnite.R
import com.go.arnite.ui.user.main.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by hanilozmen on 8/24/2019.
 */
class HistoryFragment: BaseFragment(),
    HistoryContract.View {
    private var mPresenter: HistoryContract.Presenter? = null

    private lateinit var mRootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_history, container, false)
        attachPresenter(HistoryPresenter(this))
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        detachPresenter()
        super.onDestroyView()
    }

    override fun attachPresenter(presenter: HistoryContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

}