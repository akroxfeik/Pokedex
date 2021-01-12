package com.tekever.pokemon.view.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.BR
import com.tekever.pokemon.model.PokemonAbility
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel
import kotlinx.android.synthetic.main.view_ability_list_item.view.*

class AbilityListViewHolder constructor(private val dataBinding: ViewDataBinding, private val moveListViewModel: PokemonViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val tvIsHidden = itemView.tvIsHidden
    fun setup(itemData: PokemonAbility) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
        if(itemData.is_hidden)
        {
            tvIsHidden.text = "Hidden Ability"
        }
    }
}