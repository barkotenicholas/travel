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

        val topLevelDestinations = setOf(R.id.fragmentCityList,R.id.fragmentFavoriteList)

        val appBarConfig = AppBarConfiguration(topLevelDestinations)

        binding.activityMainToolbar.setupWithNavController(navController,appBarConfig)

        binding.bottomNavView.setupWithNavController(navController)

    }


}