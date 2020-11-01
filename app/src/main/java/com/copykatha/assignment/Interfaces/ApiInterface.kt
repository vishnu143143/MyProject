package com.copykatha.assignment.Interfaces

import com.copykatha.assignment.Models.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    @GET("tweets")
    fun hitData(): Call<DataModel>
}