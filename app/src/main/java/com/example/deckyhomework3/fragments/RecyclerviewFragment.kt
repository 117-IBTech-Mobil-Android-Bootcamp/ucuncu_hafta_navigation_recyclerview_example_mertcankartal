package com.example.deckyhomework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deckyhomework3.R
import com.example.deckyhomework3.adapter.Adapter
import com.example.deckyhomework3.base.BaseFragment
import com.example.deckyhomework3.model.AvatarModel

class RecyclerviewFragment : BaseFragment() {

    private lateinit var recyclerView : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun getLayoutID(): Int = R.layout.fragment_recyclerview

    override fun isNavigationbarVisible(): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //avatar images and text
        val image1 = AvatarModel(R.drawable.ic_avatar01,null,Adapter.VIEW_SECOND)
        val image2 = AvatarModel(R.drawable.ic_avatar02,null,Adapter.VIEW_SECOND)
        val image3 = AvatarModel(R.drawable.ic_avatar03,null,Adapter.VIEW_SECOND)
        val image4 = AvatarModel(R.drawable.ic_avatar04,null,Adapter.VIEW_SECOND)
        val image5 = AvatarModel(R.drawable.ic_avatar05,null,Adapter.VIEW_SECOND)
        val image6 = AvatarModel(R.drawable.ic_avatar06,null,Adapter.VIEW_SECOND)
        val image7 = AvatarModel(R.drawable.ic_avatar07,null,Adapter.VIEW_SECOND)
        val image8 = AvatarModel(R.drawable.ic_avatar08,null,Adapter.VIEW_SECOND)
        val image9 = AvatarModel(R.drawable.ic_avatar09,null,Adapter.VIEW_SECOND)
        val image10 = AvatarModel(R.drawable.ic_avatar06,null,Adapter.VIEW_SECOND)
        val image11 = AvatarModel(R.drawable.ic_avatar07,null,Adapter.VIEW_SECOND)
        val image12 = AvatarModel(R.drawable.ic_avatar08,null,Adapter.VIEW_SECOND)
        val image13 = AvatarModel(R.drawable.ic_avatar09,null,Adapter.VIEW_SECOND)
        val image14 = AvatarModel(R.drawable.ic_avatar09,null,Adapter.VIEW_SECOND)
        val image15 = AvatarModel(R.drawable.ic_avatar09,null,Adapter.VIEW_SECOND)

        val textFirst = AvatarModel(null,"Kullanıcı adınızı oluşturun ve\n" +
                "size uygun bir avatar seçin",Adapter.VIEW_FIRST)

        val AvatarList = ArrayList<AvatarModel>()
        AvatarList.add(textFirst)
        AvatarList.add(image1)
        AvatarList.add(image2)
        AvatarList.add(image3)
        AvatarList.add(image4)
        AvatarList.add(image5)
        AvatarList.add(image6)
        AvatarList.add(image7)
        AvatarList.add(image8)
        AvatarList.add(image9)
        AvatarList.add(image10)
        AvatarList.add(image11)
        AvatarList.add(image12)
        AvatarList.add(image13)
        AvatarList.add(image14)
        AvatarList.add(image15)


        val adapter = Adapter(AvatarList)
        recyclerView = activity?.findViewById(R.id.recyclerView) ?: RecyclerView(requireContext())

        val layoutManager = GridLayoutManager(requireContext(),3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when(position){
                    0 -> 3
                    else -> 1
                }
            }
        }
        recyclerView.layoutManager= layoutManager
        recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

}