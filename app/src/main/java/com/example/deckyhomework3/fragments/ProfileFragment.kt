package com.example.deckyhomework3.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.deckyhomework3.R
import com.example.deckyhomework3.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment() {

    override fun getLayoutID(): Int = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        editAvatarButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment3_to_recyclerviewFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

}