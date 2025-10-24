package com.example.responsi1mobile.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobile.databinding.FragmentPlayerDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailFragment : BottomSheetDialogFragment() {
    private var _b: FragmentPlayerDetailBinding? = null
    private val b get() = _b!!

    companion object {
        private const val ARG_NAME = "arg_name"
        private const val ARG_DOB = "arg_dob"
        private const val ARG_NAT = "arg_nat"
        private const val ARG_POS = "arg_pos"

        fun newInstance(name: String, dob: String, nat: String, pos: String): PlayerDetailFragment {
            val f = PlayerDetailFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            args.putString(ARG_DOB, dob)
            args.putString(ARG_NAT, nat)
            args.putString(ARG_POS, pos)
            f.arguments = args
            return f
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = super.onCreateDialog(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        val name = arguments?.getString(ARG_NAME) ?: "-"
        val dob = arguments?.getString(ARG_DOB) ?: "-"
        val nat = arguments?.getString(ARG_NAT) ?: "-"
        val pos = arguments?.getString(ARG_POS) ?: "-"
        b.tvPlayerName.text = name
        b.tvPlayerDob.text = dob
        b.tvPlayerNationality.text = nat
        b.tvPlayerPosition.text = pos
        return b.root
    }

    override fun onDestroyView() {
        _b = null
        super.onDestroyView()
    }
}