package com.example.bookapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bookapplication.databinding.ActivityMainBinding
import com.example.bookapplication.di.Info
import com.example.bookapplication.extension.appComponent
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_activity_main)
        navView.setupWithNavController(navController)
//        DaggerAppComponent.create().inject(this)
//        (application as AppComponent).inject()
        appComponent.inject(this)
        binding.textView.text = info.text
    }
}