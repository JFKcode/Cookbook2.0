package code.with.cal.cardviewrecyclerviewtutorial

var recipesList = mutableListOf<Recipes>()

val RECIPES_ID_EXTRA = "recipesExtra"

class Recipes(
    var cover: Int,
    var author: String,
    var title: String,
    var description: String,
    val id: Int? = recipesList.size
)