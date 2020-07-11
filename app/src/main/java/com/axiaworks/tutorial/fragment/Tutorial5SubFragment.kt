package com.axiaworks.tutorial.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.FragmentTutorial5SubBinding

class Tutorial5SubFragment: Fragment() {
    companion object {
        const val TAG = "Tutorial5SubFragment"
        fun newInstance() = Tutorial5SubFragment()
    }

    private lateinit var binding: FragmentTutorial5SubBinding

    private var fragmentsEventListener: FragmentsEventListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentsEventListener = context as? FragmentsEventListener
    }

    override fun onDetach() {
        fragmentsEventListener = null
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentTutorial5SubBinding>(
            inflater, R.layout.fragment_tutorial5_sub, null, false
        ).apply {
            showConfirmDialogButton.setOnClickListener {
                fragmentsEventListener?.onClickShowConfirmDialogButton()
            }
        }
        return binding.root
    }
}