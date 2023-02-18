package com.example.androidresto.network

import java.io.Serializable

class Ingredients (
    var id: Int,
    var id_shop: Int,
    var name_fr: String,
    var create_date: String,
    var update_date: String,
    var id_pizza: Int
) : Serializable
