package com.copykatha.assignment.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


// data class DataModel(
//
//    @Expose
//    @SerializedName("albumId")
//    val albumid: Integer,
//    @Expose
//    @SerializedName("id")
//    val id: Integer,
//    @Expose
//    @SerializedName("title")
//    val title: String,
//    @Expose
//    @SerializedName("url")
//    val url: String,
//    @Expose
//    @SerializedName("thumbnailUrl")
//    val thumbnailurl: String
//)

class DataModel {
    var data = ArrayList<SecondModel>()
    constructor(data:ArrayList<SecondModel>){
        this.data = data
    }

}