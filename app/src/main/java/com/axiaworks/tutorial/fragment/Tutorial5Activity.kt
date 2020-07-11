package com.axiaworks.tutorial.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.ActivityTutorial5Binding

class Tutorial5Activity : AppCompatActivity(), FragmentsEventListener {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial5Activity::class.java)
    }

    private lateinit var binding: ActivityTutorial5Binding
    private var confirmDialog: Tutorial5ConfirmDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityTutorial5Binding>(
            this, R.layout.activity_tutorial5
        ).apply {
            activity = this@Tutorial5Activity
        }

        supportActionBar?.apply {
            title = getString(R.string.main_study_fragment)
            setDisplayHomeAsUpEnabled(true)
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                Tutorial5MainFragment.newInstance(),
                Tutorial5MainFragment.TAG
            )
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickShowMainFragmentButton() {
        replaceMainFragment()
    }

    override fun onClickShowSubFragmentButton() {
        replaceSubFragment()
    }

    override fun onClickShowSeparateFragmentButton() {
        replaceSeparateFragment()
    }

    override fun onClickShowConfirmDialogButton() {
        confirmDialog?.dismissAllowingStateLoss()
        Tutorial5ConfirmDialog.newInstance().apply {
            show(supportFragmentManager, Tutorial5ConfirmDialog.TAG)
            confirmDialog = this
        }
    }

    fun onClickMainFragment() {
        replaceMainFragment()
    }

    fun onClickSubFragment() {
        replaceSubFragment()
    }

    fun onClickSeparateFragment() {
        replaceSeparateFragment()
    }

    private fun replaceMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                Tutorial5MainFragment.newInstance(),
                Tutorial5MainFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    private fun replaceSubFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                Tutorial5SubFragment.newInstance(),
                Tutorial5SubFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    private fun replaceSeparateFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                Tutorial5SeparateFragment.newInstance(),
                Tutorial5SeparateFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }
}