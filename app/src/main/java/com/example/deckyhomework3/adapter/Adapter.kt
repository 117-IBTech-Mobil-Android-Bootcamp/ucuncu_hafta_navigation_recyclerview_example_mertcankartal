package com.example.deckyhomework3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deckyhomework3.R
import com.example.deckyhomework3.model.AvatarModel

class Adapter(val AvatarList : ArrayList<AvatarModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var selectedItemPosition = -1
    var lastItemSelectedPosition = -1

    companion object{
        const val VIEW_FIRST = 1    //for images
        const val VIEW_SECOND = 2    //for text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //layout inflater according to text type or image type

         if (viewType == VIEW_FIRST){
            return ViewHolderText(LayoutInflater.from(parent.context).inflate(R.layout.text_select_fragment,parent,false))
        }else{
            return ViewHolderImage(LayoutInflater.from(parent.context).inflate(R.layout.avatar_select_fragment,parent,false))
         }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

         if (AvatarList[position].viewType == VIEW_FIRST && holder is ViewHolderText){
             holder.bind(position)
         }else{
             (holder as ViewHolderImage).bind(position)
             if(position == selectedItemPosition)
                 holder.selectedCheckbox()
             else
                 holder.defaultCheckbox()

         }


    }

    //getting data viewType
    override fun getItemViewType(position: Int):Int{
        return AvatarList[position].viewType
    }

    //size of list
    override fun getItemCount(): Int {
        return AvatarList.size
    }

    //actions to be taken for images
  inner  class ViewHolderImage(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imageView = itemView.findViewById<AppCompatImageView>(R.id.avatar)

        fun bind(position: Int){
            val recyclerViewModel = AvatarList[position]
            imageView.setImageResource(recyclerViewModel.imageSrc!!)
        }

        //settings of checkbox
        val checkbox = itemView.findViewById<AppCompatImageView>(R.id.checkbox)

      fun defaultCheckbox() {
            checkbox.setImageResource(R.drawable.ic_unchecked_checkbox)
      }

      fun selectedCheckbox() {
          checkbox.setImageResource(R.drawable.ic_checked_checkbox)
      }
        //you cant select 2 or more at the same time
      init {
          itemView.setOnClickListener {
              selectedItemPosition = adapterPosition
              if(lastItemSelectedPosition == -1)
                  lastItemSelectedPosition = selectedItemPosition
              else {
                  notifyItemChanged(lastItemSelectedPosition)
                  lastItemSelectedPosition = selectedItemPosition
              }
              notifyItemChanged(selectedItemPosition)
          }
      }
    }

    //actions to be taken for text
    inner  class ViewHolderText(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById<AppCompatTextView>(R.id.avatar_text)

        fun bind(position: Int){
            val recyclerViewModel = AvatarList[position]
            textView.text = recyclerViewModel.text
        }
    }
}

