package com.example.androidresto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidresto.databinding.ActivityMenuBinding
import com.example.androidresto.network.NetworkConstants
import com.google.gson.JsonObject
import org.json.JSONObject

enum class Category { STARTER, MIDDLE, END}

class MenuActivity : AppCompatActivity() {
    companion object {
        val CATEGORYKEY = "CATEGORYKEY"
    }

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extra = intent.getSerializableExtra(CATEGORYKEY) as? Category
        val category = extra ?: Category.STARTER
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomAdapter(listOf("1","2","3"))
        supportActionBar?.title = categoryName(category)

        makeRequest()
        Log.d("lifecycle", "menuOnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "menuOnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "menuOnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "menuOnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "menuOnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "menuOnDestroy")
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

