package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cookbook.databinding.ActivityRecipesBinding

class RecipesActivity : AppCompatActivity() {
    private var binding : ActivityRecipesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.pasta?.setOnClickListener {
            val intent = Intent(this, PastaActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Baw się dobrze", Toast.LENGTH_LONG).show()
        }
        binding?.rissotto?.setOnClickListener {
            val intent= Intent(this, RissottoActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Baw się dobrze", Toast.LENGTH_LONG).show()
        }
        binding?.pancakes?.setOnClickListener {
            val intent= Intent(this, PancakeActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Baw się dobrze", Toast.LENGTH_LONG).show()
        }

        binding?.soup?.setOnClickListener {
            val intent= Intent(this, SoupActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Baw się dobrze", Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}