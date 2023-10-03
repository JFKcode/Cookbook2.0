package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookbook.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = Pasta_Fragment()
        val secondFragment = Tomato_Fragment()
        val thirdFragment = Garlik_Fragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, secondFragment)
            commit()
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, thirdFragment)
            commit()
        }

        binding.Pasta2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }
        binding.Tomato.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
        binding.Garlik.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, thirdFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun replace(flFragment: Int, firstFragment: Pasta_Fragment) {

    }
}



