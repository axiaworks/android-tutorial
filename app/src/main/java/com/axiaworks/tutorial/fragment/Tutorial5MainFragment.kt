package com.axiaworks.tutorial.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.FragmentTutorial5MainBinding

class Tutorial5MainFragment : Fragment() {
    companion object {
        const val TAG = "Tutorial5MainFragment"
        fun newInstance() = Tutorial5MainFragment()
    }

    private lateinit var binding: FragmentTutorial5MainBinding

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
        binding = DataBindingUtil.inflate<FragmentTutorial5MainBinding>(
            inflater, R.layout.fragment_tutorial5_main, null, false
        ).apply {
            showSubFragmentButton.setOnClickListener {
                fragmentsEventListener?.onClickShowSubFragmentButton()
            }
        }

        return binding.root
    }

}