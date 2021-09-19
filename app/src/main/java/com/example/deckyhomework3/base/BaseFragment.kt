package com.example.deckyhomework3.base

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.deckyhomework3.activity.MainActivity

abstract class BaseFragment : Fragment(), FragmentInterface {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()

        val baseActivity = activity as MainActivity

        if(isNavigationbarVisible())
            baseActivity.showNavigation()
        else
            baseActivity.hideNavigation()

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner,object :
        OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                pressedBack()
            }
        })

    }

    //when pressedBack calculate backStackEntryCount func
    private fun pressedBack(){
        val navHostFragment = this.parentFragment as NavHostFragment?
        if (navHostFragment?.childFragmentManager?.backStackEntryCount == 1){
            popUpShow()
        }else{
            navHostFragment?.findNavController()?.navigateUp()
        }
    }

    //show pop message when quit from app
    private fun popUpShow(){
        val alert =AlertDialog.Builder(requireContext())
            alert.setTitle("Uygulamayı Kapat")
            alert.setMessage("Uygulamadan çıkmak istediğine emin misin ?")
            alert.setCancelable(false)
            alert.setNegativeButton("EVET"){dialog,which ->
                activity?.finish()
            }
            alert.setPositiveButton("Hayır"){dialog,which ->
                dialog.cancel()
            }.show()
    }

    //inflating layout xml
    abstract fun getLayoutID() : Int


}