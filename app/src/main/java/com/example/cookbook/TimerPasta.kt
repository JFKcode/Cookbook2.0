package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookbook.databinding.ActivityTimerPastaBinding

class TimerPasta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTimerPastaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment2 = Cacke_Fragment()
        val secondFragment2 = SmazenieFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment2, firstFragment2)
            commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment2, secondFragment2)
            commit()
        }


        binding.Ciasto.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment2, firstFragment2)
                addToBackStack(null)
                commit()
            }
        }
        binding.Smazenie.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment2, secondFragment2)
                addToBackStack(null)
                commit()
            }
        }

            }
    private fun replace(flFragment: Int, firstFragment: Cacke_Fragment) {

    }
}









