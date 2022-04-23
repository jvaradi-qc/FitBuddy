package com.groupsix.fitbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser
import com.groupsix.fitbuddy.fragments.ComposeFragment
import com.groupsix.fitbuddy.fragments.HealthFragment
import com.groupsix.fitbuddy.fragments.HomeFragment
import com.groupsix.fitbuddy.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    //Option menu created
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Logout btn selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "Button clicked")
        ParseUser.logOut()
        val currentUser = ParseUser.getCurrentUser()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->
            var fragmentToShow: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> {
                    fragmentToShow = HomeFragment()
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.action_compose -> {
                    fragmentToShow = ComposeFragment()
                    Toast.makeText(this, "Compose", Toast.LENGTH_SHORT).show()
                }
                R.id.action_health -> {
                    fragmentToShow = HealthFragment()
                    Toast.makeText(this, "Health", Toast.LENGTH_SHORT).show()
                }
                R.id.action_profile -> {
                    fragmentToShow = ProfileFragment()
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
            }
            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow)
                    .commit()
            }

            true
        }
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

    }

    companion object {
        const val TAG = "MainActivity"
    }
}