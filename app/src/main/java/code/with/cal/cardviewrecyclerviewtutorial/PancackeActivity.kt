package code.with.cal.cardviewrecyclerviewtutorial

import code.with.cal.cardviewrecyclerviewtutorial.databinding.ActivityPancackeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import android.os.Handler
import android.os.Looper


class PancackeActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPancackeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val firstFragment2 = CackeFragment()
        val secondFragment2 = SmazenieFragment()

        // Przekaż dane do zachowania do Bundle.
        val savedState = savedInstanceState ?: Bundle()
        mainViewModel.countdownTime.value?.let { savedState.putLong("countdownTime", it) }

        // Dodaj fragment domyślny
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment2, firstFragment2)
                commit()
            }
        }

        binding.Ciasto?.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment2, firstFragment2)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        binding.Smazenie?.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment2, secondFragment2)
                    addToBackStack(null)
                    commit()
                }
            }
        }

        fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)

            // Zapisz dane do zachowania w Bundle.
            mainViewModel.countdownTime.value?.let { outState.putLong("countdownTime", it) }
        }

        fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)

        }
    }
}













