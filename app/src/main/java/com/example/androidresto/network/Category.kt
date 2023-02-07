package com.example.androidresto.network

import com.google.gson.annotations.SerializedName

class Category( @SerializedName("name_fr") val name : String,
                @SerializedName("items") val items : List <Plate>): java.io.Serializable