package com.example.androidresto.network

import com.google.gson.annotations.SerializedName

class Price (@SerializedName("price") val price : Float,
             @SerializedName("id") val id : Int,
             @SerializedName("id_pizza") val id_pizza : Int,
             @SerializedName("id_size") val id_size : Int,
             @SerializedName("create_date") val create_date : String,
             @SerializedName("update_date") val update_date : String,
             @SerializedName("size") val size : String,): java.io.Serializable
