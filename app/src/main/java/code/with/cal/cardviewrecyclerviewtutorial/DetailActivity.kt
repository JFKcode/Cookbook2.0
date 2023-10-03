package code.with.cal.cardviewrecyclerviewtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import code.with.cal.cardviewrecyclerviewtutorial.databinding.ActivityDetailBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recipesID = intent.getIntExtra(RECIPES_ID_EXTRA, -1)
        val recipes = recipesFromID(recipesID)
        if(recipes != null)
        {
            binding.cover.setImageResource(recipes.cover)
            binding.title.text = recipes.title
            binding.description.text = recipes.description
            binding.author.text = recipes.author

            mainViewModel.updateTextViewContent("${recipes.title}\n${recipes.description}")
        }

        binding.przygotuj.setOnClickListener {
            val intent = Intent(this, PastaActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Baw się dobrze", Toast.LENGTH_LONG).show()
        }

        val sendFabBtn = findViewById<FloatingActionButton>(R.id.mainFabBtn)
        sendFabBtn.setOnClickListener {
            // Pobiera zawartość strony
            val pageContent = binding.title.text.toString() + "\n" + binding.description.text.toString()

            // Intencja do wysłania zawartości do Messages
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, pageContent)
            sendIntent.type = "text/plain"

            // Wybierz Messages jako aplikację docelową
            sendIntent.setPackage("com.google.android.apps.messaging") // Zmień na odpowiednią nazwę pakietu Messages

            // Uruchom Intencję
            startActivity(sendIntent)
        }


    }



    private fun recipesFromID(recipesID: Int): Recipes?
    {
        for(recipes in recipesList)
        {
            if(recipes.id == recipesID)
                return recipes
        }
        return null
    }


}