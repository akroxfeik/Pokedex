package com.tekever.pokemon.view.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.BR
import com.tekever.pokemon.model.PokemonMove
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel

class MoveListViewHolder constructor(private val dataBinding: ViewDataBinding, private val moveListViewModel: PokemonViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: PokemonMove) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
    }
}