package code.with.cal.cardviewrecyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import android.os.Handler
import android.os.Looper
import code.with.cal.cardviewrecyclerviewtutorial.databinding.ActivityPastaBinding

class PastaActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPastaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val firstFragment = PastaFragment()
        val secondFragment = Tomato_Fragment()
        val thirdFragment = GarlikFragment()

        // Przekaż dane do zachowania do Bundle.
        val savedState = savedInstanceState ?: Bundle()
        mainViewModel.countdownTime.value?.let { savedState.putLong("countdownTime", it) }

        // Dodaj fragment domyślny
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                commit()
            }
        }

        binding.Pasta2.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, firstFragment)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        binding.Tomato.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, secondFragment)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        binding.Garlik.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, thirdFragment)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Zapisz dane do zachowania w Bundle.
        mainViewModel.countdownTime.value?.let { outState.putLong("countdownTime", it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

    }
}







