package com.example.deckyhomework3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.deckyhomework3.R
import com.example.deckyhomework3.utils.gone
import com.example.deckyhomework3.utils.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fragmentContainerView connect with bottomnavigationmenu
        val navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(bottomnavigationmenu,navController)


    }

    //we dont want to show bottomNavigationBar when splash fragment opening
    fun hideNavigation() {
        bottomnavigationmenu.postDelayed(
            {
                bottomnavigationmenu.gone()

            }, 0
        )
    }

    fun showNavigation() {
        bottomnavigationmenu.postDelayed(
            {
                bottomnavigationmenu.visible()

            }, 500
        )
    }
}