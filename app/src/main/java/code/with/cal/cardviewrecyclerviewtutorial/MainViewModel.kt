package code.with.cal.cardviewrecyclerviewtutorial

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class MainViewModel : ViewModel() {
    private var countdownTimer: CountDownTimer? = null
    private val _countdownTime = MutableLiveData<Long>()
    val countdownTime: LiveData<Long>
        get() = _countdownTime

    // Publiczna metoda do aktualizacji LiveData
    fun updateCountdownTime(timeInSeconds: Long) {
        _countdownTime.postValue(timeInSeconds)
    }

    fun startCountdown(totalSeconds: Int) {
        resetCountdown()

        countdownTimer = object : CountDownTimer((totalSeconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                updateCountdownTime(millisUntilFinished / 1000) // Aktualizuj LiveData
                Log.d("MainViewModel", "Countdown onTick: $millisUntilFinished milliseconds remaining.")
            }

            override fun onFinish() {
                updateCountdownTime(0) // Aktualizuj LiveData
                Log.d("MainViewModel", "Countdown onFinish: Countdown finished.")
            }
        }.start()
    }

    // zmienną do przechowywania zawartości TextView w DetailActivity
    private val _textViewContent = MutableLiveData<String>()
    val textViewContent: LiveData<String>
        get() = _textViewContent

    // metoda do aktualizacji LiveData zawartości TextView
    fun updateTextViewContent(content: String) {
        _textViewContent.postValue(content)
    }

    fun resetCountdown() {
        countdownTimer?.cancel()
        updateCountdownTime(0) // Aktualizuj LiveData
        Log.d("MainViewModel", "Resetting countdown.")
    }
}

