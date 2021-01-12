package com.tekever.pokemon.view.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.BR
import com.tekever.pokemon.model.PokemonPokeDexNumber
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel

class PokeDexListViewHolder constructor(private val dataBinding: ViewDataBinding, private val moveListViewModel: PokemonViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: PokemonPokeDexNumber) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
    }
}