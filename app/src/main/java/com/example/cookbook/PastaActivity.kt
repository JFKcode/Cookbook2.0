package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cookbook.databinding.ActivityPastaBinding

class PastaActivity : AppCompatActivity() {
    private var binding:ActivityPastaBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPastaBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.start1?.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
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