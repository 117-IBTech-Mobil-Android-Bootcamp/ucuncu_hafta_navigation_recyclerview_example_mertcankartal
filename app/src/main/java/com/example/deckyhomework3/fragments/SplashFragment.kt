package com.example.deckyhomework3.fragments

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.deckyhomework3.R
import com.example.deckyhomework3.base.BaseFragment


class SplashFragment : BaseFragment() {

    private val handler = Handler()

    override fun getLayoutID(): Int = R.layout.fragment_splash

    override fun isNavigationbarVisible(): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //3sec after goes to home fragment
        handler.postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment3)
        },3000)
        super.onViewCreated(view, savedInstanceState)
    }
}