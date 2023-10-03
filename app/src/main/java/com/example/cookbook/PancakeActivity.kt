package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cookbook.databinding.ActivityPancakeBinding


class PancakeActivity : AppCompatActivity() {
    private var binding:ActivityPancakeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPancakeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.start2?.setOnClickListener {
            val intent = Intent(this, TimerPasta::class.java)
            startActivity(intent)

            Toast.makeText(this, "Włącz stoper", Toast.LENGTH_LONG).show()

            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        }

        fun onDestroy() {
            super.onDestroy()
            binding = null
        }

    }
}