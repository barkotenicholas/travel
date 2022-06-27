package com.barkote.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.barkote.travel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController  : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFrag = supportFragmentManager.findFragmentById(binding.navHostFrag.id) as NavHostFragment
        navController = navHostFrag.navController

        val appBarConfig = AppBarConfiguration(navController.graph,binding.drawer)

        binding.activityMainToolbar.setupWithNavController(navController,appBarConfig)

        binding.navView.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        if(binding.drawer.isOpen){
            binding.drawer.close()
        }else{
            super.onBackPressed()
        }
    }
}