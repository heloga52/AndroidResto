package com.example.androidresto

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.androidresto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonclicklistener()
    }

    fun buttonclicklistener () {
        binding.starter.setOnClickListener {
            showCategory(Category.STARTER)
        }
        binding.middle.setOnClickListener {
            showCategory(Category.MIDDLE)
        }
        binding.end.setOnClickListener {
            showCategory(Category.END)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_menu)
        Log.d("lifecycle", "mainOnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "mainOnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "mainOnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "mainOnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "mainOnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "mainOnDestroy")
    }

    private fun showCategory(category: Category){
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra(MenuActivity.CATEGORYKEY, category)
        startActivity(intent)
    }

}
