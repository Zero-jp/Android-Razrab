package com.igor.android.mooddiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.igor.android.mooddiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import androidx.navigation.findNavController
//import androidx.navigation.ui.NavigationUI

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        var navController = this.findNavController(R.id.myNavHostFragment)
//
//        NavigationUI.setupActionBarWithNavController(this, navController)
//
//        this.title = "your title";
//
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        var navController = this.findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp()
//    }
//}