package code.with.cal.cardviewrecyclerviewtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import code.with.cal.cardviewrecyclerviewtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecipesClickListener
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateRecipes()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(recipesList, mainActivity)
        }
    }
    override fun onClick(recipes: Recipes)
    {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(RECIPES_ID_EXTRA, recipes.id)
        startActivity(intent)
    }

    private fun populateRecipes()
    {
        val recipes1 = Recipes(
            R.drawable.pasta,
            "Jakub Frąckowiak",
            "Makaron z pomidorami",
            "Potrzebne składniki:\n" + "\n" + "1. Makaron 200g \n" + "\n" + "2. Puszka pomidorów 400g \n" + "\n" + "3. Oliwa z oliwek 3 łyżk \n" + "\n" + "4. Czosne 2 zbąki \n" + "\n" + "5. Sól i piper \n" + "\n" + "6. Ser Grana Padano \n" + "\n" + "Przygotowanie: \n" + "\n" + "Do garnka wlać oliwę i dodać obrane zbąki czosnku, smażyć na średnim ogniu przez 5min. \n" + "\n" + "Po tym czasie wyciągnąć czosnek i dodać puszkę pomidorów. \n" + "\n" + "Dodać sól pieprz i dusić przez 20min. \n" + "\n" + "Po tym czasie odstawić do odparowania. \n" + "\n" + "Następnie zagotować wodę na makaron i gotować przez 10min. \n" + "\n" + "Po ugotowaniu makaronu dodać usmażony czosnek do sosu i podgrzać przez 2min na średnim ogniu."
        )
        recipesList.add(recipes1)

        val recipes2 = Recipes(
            R.drawable.pancacke,
            "Wiktor Kubski",
            "Naleśniki",
            "Potrzebne składniki:\n" + "\n" + "1. Szklanak mleka 300ml2.\n" + "\n" + "Woda gazowana 100ml. \n" + "\n" + "3. 2 jajka \n" + "\n" + "4. 30g masł \n" + "\n" + "5. Sól6. 300g  \n" + "\n" + "Przygotowanie: \n" + "\n" + "Dodać wszystkie składniki i miksować przez 5min\n" + "\n" + "Wyrobioną masę zostawić na 30min" + "\n" + "Po tym czasie wymieszać i rozgrzać mocno patelnię. \n" + "\n" + "Wylewamy ciasto na patelnie i smażymy przez 2min na każdej stronie."
        )
        recipesList.add(recipes2)

        val recipes3 = Recipes(
            R.drawable.rissotto,
            "Łukasz John",
            "Rissotto",
            "Do dodania",
        )
        recipesList.add(recipes3)

        val recipes4 = Recipes(
            R.drawable.soup,
            "Janusz Kowalski",
            "Zupa Pomidorowa",
            "Do dodania",
        )
        recipesList.add(recipes4)

        val recipes5 = Recipes(
            R.drawable.lasagne,
            "Mateusz Marek",
            "Lasagne",
            "Do dodania",
        )
        recipesList.add(recipes5)

        val recipes6 = Recipes(
            R.drawable.pizza,
            "Biedny Student",
            "Pizza",
            "Do dodania",
        )
        recipesList.add(recipes6)

        val recipes7 = Recipes(
            R.drawable.ramen,
            "Donald Tusk",
            "Ramen",
            "Do dodania",
        )
        recipesList.add(recipes7)


        recipesList.add(recipes1)
        recipesList.add(recipes2)
        recipesList.add(recipes3)
        recipesList.add(recipes4)

    }


}