package com.axiaworks.tutorial.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.axiaworks.tutorial.R
import com.axiaworks.tutorial.databinding.FragmentTutorial5SeparateBinding

class Tutorial5SeparateFragment: Fragment() {
    companion object {
        const val TAG = "Tutorial5SeparateFragment"
        fun newInstance() = Tutorial5SeparateFragment()
    }

    private lateinit var binding: FragmentTutorial5SeparateBinding

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
        binding = DataBindingUtil.inflate<FragmentTutorial5SeparateBinding>(
            inflater, R.layout.fragment_tutorial5_separate, null, false
        ).apply {
            requireFragmentManager().beginTransaction()
                .replace(
                    R.id.main_fragment_container,
                    Tutorial5MainFragment.newInstance(),
                    Tutorial5MainFragment.TAG
                )
                .replace(
                    R.id.sub_fragment_container,
                    Tutorial5SubFragment.newInstance(),
                    Tutorial5SubFragment.TAG
                )
                .commit()
        }
        return binding.root
    }
}