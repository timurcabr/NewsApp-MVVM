package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.home.HomeFragment
import com.example.newsapp.ui.saved.SavedFragment
import com.example.newsapp.ui.search.SearchFragment
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                val answer1 = async { networkCall1() }
//                val answer2 = async { networkCall2() }
//                Log.i("MyData", "Answer 1 is ${answer1.await()}")
//                Log.i("MyData", "Answer 2 is ${answer2.await()}")
//            }
//            Log.i("MyData", "Time $time")
//        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setFragment(HomeFragment())
                R.id.saved -> setFragment(SavedFragment())
                R.id.search -> setFragment(SearchFragment())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}