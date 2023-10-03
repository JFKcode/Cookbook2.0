package code.with.cal.cardviewrecyclerviewtutorial

import androidx.recyclerview.widget.RecyclerView
import code.with.cal.cardviewrecyclerviewtutorial.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: RecipesClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindBook(recipes: Recipes)
    {
        cardCellBinding.cover.setImageResource(recipes.cover)
        cardCellBinding.title.text = recipes.title
        cardCellBinding.author.text = recipes.author

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(recipes)
        }
    }
}