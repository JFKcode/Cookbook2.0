package com.example.cookbook

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Tomato_Fragment : Fragment(R.layout.fragment_tomato_) {

    private lateinit var etMinutes: EditText
    private lateinit var btnSetTime: Button
    private lateinit var btnReset: Button
    private lateinit var tvCountdown: TextView
    private var countdownTimer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tomato_, container, false)

        etMinutes = view.findViewById(R.id.etMinutes)
        btnSetTime = view.findViewById(R.id.btnSetTime)
        btnReset = view.findViewById(R.id.btnReset)
        tvCountdown = view.findViewById(R.id.tvCountdown)

        btnSetTime.setOnClickListener {
            val minutes = etMinutes.text.toString().toIntOrNull()
            if (minutes != null && minutes > 0) {
                startCountdown(minutes * 60)
            }
        }

        btnReset.setOnClickListener {
            resetCountdown()
        }

        return view
    }

    private fun startCountdown(totalSeconds: Int) {
        resetCountdown()

        countdownTimer = object : CountDownTimer((totalSeconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 60000
                val seconds = (millisUntilFinished % 60000) / 1000
                val formattedTime = String.format("%02d:%02d", minutes, seconds)
                tvCountdown.text = formattedTime
            }

            override fun onFinish() {
                tvCountdown.text = "00:00"
            }
        }.start()
    }

    private fun resetCountdown() {
        countdownTimer?.cancel()
        tvCountdown.text = "00:00"
    }

}


