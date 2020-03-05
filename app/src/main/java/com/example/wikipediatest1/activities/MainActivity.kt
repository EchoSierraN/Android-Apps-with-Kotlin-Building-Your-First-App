package com.example.wikipediatest1.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wikipediatest1.R
import kotlinx.android.synthetic.main.activity_article_detail.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener= BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigation_home->{
                message.setText("R.string.title_home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard->{
                message.setText("R.string.title_dashboard")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications->{
                message.setText("R.string.title_notifications")
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        message.setOnClickListener{
            startActivity(Intent(this, ArticleDetailActivity::class.java))
        }

        setSupportActionBar(toolbar)
        /*get a reference of this activity's action bar and
        * enable the back button at the top left of it*/
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId== android.R.id.home){
            finish()
        }
        return true
    }
}
