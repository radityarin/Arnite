package com.go.arnite.ui.user.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.go.arnite.R
import com.go.arnite.ui.common.signin.SignInActivity
import com.go.arnite.ui.user.main.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by hanilozmen on 8/24/2019.
 */
class ProfileFragment : BaseFragment(),
    ProfileContract.View, View.OnClickListener {

    private lateinit var mRootView: View
    private var mPresenter: ProfileContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(R.layout.fragment_profile, container, false)
        attachPresenter(ProfilePresenter(this))
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sign_out.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_sign_out -> mPresenter?.logOut()
        }
    }


    override fun onDestroyView() {
        detachPresenter()
        super.onDestroyView()
    }

    override fun attachPresenter(presenter: ProfileContract.Presenter) {
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

    override fun onLogoutSuccess(message: String) {
        startActivity(Intent(activity, SignInActivity::class.java))
        activity?.finishAffinity()
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onLogoutFailure(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}