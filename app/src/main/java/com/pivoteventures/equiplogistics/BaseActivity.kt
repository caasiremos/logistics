package com.pivoteventures.equiplogistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.pivoteventures.equiplogistics.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    private lateinit var navController: NavController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the navigation host container hosting the fragments
        val hostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_container) as NavHostFragment

        // Attach the created navigation container to navigation controller that handles navigation within the created container
        navController = hostFragment.findNavController()
        setSupportActionBar(binding.toolbar)

        // Setup action bar(<- back icon) for top level destination and inflate action bar titles if provided
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        //the reasons we initialize appBarConfiguration variable globally is to pass it here where
        //back stack of top level navigation is handled
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}