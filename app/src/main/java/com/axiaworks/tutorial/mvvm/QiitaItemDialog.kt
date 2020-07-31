package com.axiaworks.tutorial.mvvm

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.DialogQiitaItemBinding

class QiitaItemDialog : DialogFragment() {
    companion object {
        private const val ARGS_URL = "url"
        fun newInstance(content: String) = QiitaItemDialog().apply {
            arguments = Bundle().apply {
                putString(ARGS_URL, content)
            }
        }
    }

    private lateinit var binding: DialogQiitaItemBinding

    private val url : String by lazy {
        arguments?.getString(ARGS_URL) ?: ""
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate<DialogQiitaItemBinding>(
            LayoutInflater.from(requireContext()), R.layout.dialog_qiita_item, null, false
        ).apply {
            if (url.isBlank()) {
                dismissAllowingStateLoss()
            } else {
                webView.loadUrl(url)
                closeButton.setOnClickListener {
                    dismissAllowingStateLoss()
                }
            }
        }

        return Dialog(requireContext()).apply {
            setContentView(binding.root)
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }
}