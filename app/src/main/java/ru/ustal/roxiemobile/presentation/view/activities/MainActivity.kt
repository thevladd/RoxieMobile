package ru.ustal.roxiemobile.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ustal.roxiemobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_orders, R.id.navigation_order_detail
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}