package com.axiaworks.tutorial.mvvm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.ActivityTutorial6Binding
import org.koin.android.viewmodel.ext.android.viewModel

class Tutorial6Activity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, Tutorial6Activity::class.java)
    }

    private val viewModel: Tutorial6ViewModel by viewModel()

    private lateinit var binding: ActivityTutorial6Binding
    private var adapter: QiitaItemAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityTutorial6Binding>(
            this, R.layout.activity_tutorial6
        ).apply {
            recyclerView.adapter = QiitaItemAdapter(emptyList()).apply {
                this@Tutorial6Activity.adapter = this
            }
            searchButton.setOnClickListener {
                viewModel.fetchTagItems("android")
            }
        }

        bindViews()

        supportActionBar?.apply {
            title = getString(R.string.main_study_mvvm)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun bindViews() {
        viewModel.isProgress.observe(this, Observer {
            binding.progressContainer.visibility = if (it == true) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.qiitaItems.observe(this, Observer {
            it?.let { list ->
                adapter?.setList(list)
            }
        })
    }
}