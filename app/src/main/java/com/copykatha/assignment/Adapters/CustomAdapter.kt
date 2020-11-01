package com.copykatha.assignment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.copykatha.assignment.Models.SecondModel
import com.copykatha.assignment.R
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso
import android.graphics.BitmapFactory

import android.provider.ContactsContract.CommonDataKinds.Website.URL


class CustomAdapter(val listOfArray: ArrayList<SecondModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context)
            .inflate(R.layout.all_details, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listOfArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text=listOfArray[position].name
        holder.surnameText.text=listOfArray[position].handle
        holder.favoriteCount.text=(listOfArray[position].favoriteCount).toString()
        holder.retweetCount.text=(listOfArray[position].retweetCount).toString()
        holder.text.text=listOfArray[position].text

       val base64String = listOfArray[position].profileImageUrl
      Picasso.get().load(base64String).into(holder.profileImage)



    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewName = itemView.findViewById(R.id.nameText) as TextView
        var profileImage = itemView.findViewById(R.id.profileImage) as CircularImageView
        var surnameText = itemView.findViewById(R.id.surnameText) as TextView
        var favoriteCount = itemView.findViewById(R.id.favoriteCount) as TextView
        var retweetCount = itemView.findViewById(R.id.retweetCount) as TextView
        var text = itemView.findViewById(R.id.text) as TextView
    }
}