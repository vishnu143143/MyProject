package com.copykatha.assignment.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.copykatha.assignment.Adapters.CustomAdapter
import com.copykatha.assignment.Models.ApiClient
import com.copykatha.assignment.Models.DataModel
import com.copykatha.assignment.Models.SecondModel
import com.copykatha.assignment.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        b1.setOnClickListener {
            var editTextHello = findViewById(R.id.searchBar) as TextInputEditText

            if (editTextHello.text.toString().equals("")) {
                recyclerView.visibility = View.INVISIBLE
                searchImage.visibility = View.VISIBLE

            } else {
                recyclerView.visibility = View.VISIBLE
                searchImage.visibility = View.INVISIBLE
                call(editTextHello.text.toString())
            }


        }


    }

    private fun call(name: String) {
        var arrayListTwo: ArrayList<SecondModel>? = ArrayList<SecondModel>()
        var arrayList: ArrayList<SecondModel>? = null
        val call: Call<DataModel> = ApiClient.getClient.hitData()
        call.enqueue(object : Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(MainActivity())


                val User: DataModel = response.body()!!
                arrayList = User.data

                for ((index, value) in arrayList!!.withIndex()) {
                    if (value.name.toString().equals(name)) {
                        arrayListTwo?.add(
                            SecondModel(
                                value.name,
                                value.handle,
                                value.favoriteCount,
                                value.retweetCount,
                                value.profileImageUrl,
                                value.text
                            )
                        )
                    }

                }


                val adapter = CustomAdapter(arrayListTwo!!)
                recyclerView.adapter = adapter
            }


        })
    }


    private fun getData() {
        var arrayListTwo: ArrayList<SecondModel>? = ArrayList<SecondModel>()
        var arrayList: ArrayList<SecondModel>? = null
        val call: Call<DataModel> = ApiClient.getClient.hitData()
        call.enqueue(object : Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(MainActivity())


                val User: DataModel = response.body()!!
                arrayList = User.data

                val adapter = CustomAdapter(arrayList!!)
                recyclerView.adapter = adapter
            }


        })
    }
}
