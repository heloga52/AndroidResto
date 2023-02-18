package com.example.androidresto.network

import com.google.gson.annotations.SerializedName

class Plate (@SerializedName("name_fr") val name : String,
             @SerializedName("images") val images : List <String>,
             @SerializedName("prices") val prices : List <Price>,
             @SerializedName("ingredients") val ingredients : List <Ingredients>,
             @SerializedName("id") val id : Int,
             @SerializedName("category_name_fr") val category_name_fr : String,
             @SerializedName("id_category") val id_category : Int): java.io.Serializable