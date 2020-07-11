package com.axiaworks.tutorial.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.DialogTutorial5ConfirmBinding

class Tutorial5ConfirmDialog: DialogFragment() {
    companion object {
        const val TAG = "Tutorial5ConfirmDialog"
        fun newInstance() = Tutorial5ConfirmDialog()
    }

    private lateinit var binding: DialogTutorial5ConfirmBinding

    private var fragmentsEventListener: FragmentsEventListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentsEventListener = context as? FragmentsEventListener
    }

    override fun onDetach() {
        fragmentsEventListener = null
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate<DialogTutorial5ConfirmBinding>(
            LayoutInflater.from(requireContext()), R.layout.dialog_tutorial5_confirm, null, false
        ).apply {
            mainButton.setOnClickListener {
                fragmentsEventListener?.onClickShowMainFragmentButton()
                dismissAllowingStateLoss()
            }
            subButton.setOnClickListener {
                fragmentsEventListener?.onClickShowSubFragmentButton()
                dismissAllowingStateLoss()
            }
            separateButton.setOnClickListener {
                fragmentsEventListener?.onClickShowSeparateFragmentButton()
                dismissAllowingStateLoss()
            }
            cancelButton.setOnClickListener {
                dismissAllowingStateLoss()
            }
        }

        return Dialog(requireContext()).apply {
            setContentView(binding.root)
        }
    }

}