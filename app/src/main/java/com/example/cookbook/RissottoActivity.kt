package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.cookbook.databinding.ActivityRissottoBinding

class RissottoActivity : AppCompatActivity() {
    private var binding:ActivityRissottoBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRissottoBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupRestView(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }

        setRestProgressBar()
    }

    private fun setRestProgressBar(){
        binding?.progressBar?.progress = restProgress

        restTimer = object: CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }

            override fun onFinish() {

                Toast.makeText(
                    this@RissottoActivity,
                    "YEZZZZ",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }.start()

    }
    override fun onDestroy() {
        super.onDestroy()

        if(restTimer!= null){
            restTimer?.cancel()
            restProgress = 0
        }

        binding = null
    }
}