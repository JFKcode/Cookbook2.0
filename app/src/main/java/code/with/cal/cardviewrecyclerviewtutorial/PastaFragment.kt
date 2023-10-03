package code.with.cal.cardviewrecyclerviewtutorial

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class PastaFragment : Fragment(R.layout.fragment_pasta) {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var etMinutes: EditText
    private lateinit var btnSetTime: Button
    private lateinit var btnReset: Button
    private lateinit var tvCountdown: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pasta, container, false)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        etMinutes = view.findViewById(R.id.etMinutes)
        btnSetTime = view.findViewById(R.id.btnSetTime)
        btnReset = view.findViewById(R.id.btnReset)
        tvCountdown = view.findViewById(R.id.tvCountdown)

        // Ustaw licznik na podstawie wartości z ViewModel.
        mainViewModel.countdownTime.value?.let { updateCountdownUI(it) }

        btnSetTime.setOnClickListener {
            val minutes = etMinutes.text.toString().toIntOrNull()
            if (minutes != null && minutes > 0) {
                // Rozpocznij odliczanie z nowym czasem.
                mainViewModel.startCountdown(minutes * 60)
                Log.d("Pasta_Fragment", "btnSetTime clicked: Starting countdown for $minutes minutes.")
            }
        }

        btnReset.setOnClickListener {
            mainViewModel.resetCountdown()
            Log.d("Pasta_Fragment", "btnReset clicked: Resetting countdown.")
        }

        mainViewModel.countdownTime.observe(viewLifecycleOwner, { remainingTime ->
            updateCountdownUI(remainingTime ?: 0)
            Log.d("Pasta_Fragment", "Countdown time updated: $remainingTime seconds remaining.")
        })

        return view
    }

    private fun updateCountdownUI(remainingTime: Long) {
        val minutes = remainingTime / 60
        val seconds = remainingTime % 60
        val formattedTime = String.format("%02d:%02d", minutes, seconds)
        tvCountdown.text = formattedTime
        Log.d("Pasta_Fragment", "Updating countdown UI: $formattedTime")
    }
}

