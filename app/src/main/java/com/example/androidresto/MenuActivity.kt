package com.example.androidresto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidresto.databinding.ActivityMenuBinding
import com.example.androidresto.network.NetworkConstants
import com.example.androidresto.network.Plate
import com.google.gson.JsonObject
import org.json.JSONObject

enum class Category { STARTER, MIDDLE, END }


class MenuActivity : AppCompatActivity() {
    companion object {
        val CATEGORYKEY = "CATEGORYKEY"
    }

    lateinit var binding: ActivityMenuBinding
    lateinit var currentCategory: Category
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extra = intent.getSerializableExtra(CATEGORYKEY) as? Category
        val category = extra ?: Category.STARTER

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomAdapter(listOf()){
            goToDetails(it)
        }

        supportActionBar?.title = categoryName(category)

        makeRequest()
        Log.d("lifecycle", "menuOnCreate")
    }

    private fun categoryFilterKey(): String {
        return when(currentCategory) {
            Category.STARTER -> "Entrées"
            Category.MIDDLE -> "Plats"
            Category.END -> "Desserts"
        }
    }

    private fun goToDetails(plate: Plate)
    {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("plate",plate)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d( "lifeCycle", "MenuListActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "MenuListActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "MainActivity onPause")
    }

    override fun onDestroy() {
        Log.d("lifeCycle", "MainActivity onDestroy")
        super.onDestroy()
    }


    private fun categoryName(category: Category): String {
        return when(category) {
            Category.STARTER -> getString(R.string.starter)
            Category.MIDDLE -> getString(R.string.middle)
            Category.END -> getString(R.string.end)
        }
    }

    private fun makeRequest(){
        val queue = Volley.newRequestQueue(this)
        val params = JSONObject()
        params.put(NetworkConstants.ID_SHOP, "1")
        val request = JsonObjectRequest(
            Method.POST,
            NetworkConstants.BASEURL,
            params,
            {
                Log.d("request", it.toString(2))
            },
            {
                Log.e("request", it.toString())
            }
        )
        queue.add(request)
    }
}

