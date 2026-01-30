package com.example.advanceuinavapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apply window insets for edge-to-edge display if root view exists
        val root = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        root?.let { r ->
            ViewCompat.setOnApplyWindowInsetsListener(r) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Setup Navigation Component with BottomNavigationView in a robust way
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        val navController = navHostFragment?.navController
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        if (navController != null) {
            bottomNav.setupWithNavController(navController)
        }
    }
}