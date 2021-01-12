package com.tekever.pokemon.view.adapter.viewHolders

import androidx.core.os.bundleOf
import com.tekever.pokemon.BR;
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tekever.pokemon.R
import com.tekever.pokemon.model.PokeRep
import com.tekever.pokemon.model.PokemonItem
import com.tekever.pokemon.view.ui.pokelist.MainViewModel
import kotlinx.android.synthetic.main.view_pokemon_list_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class PokemonListViewHolder constructor(private val dataBinding: ViewDataBinding, private val pokeListViewModel: MainViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {
    val img = itemView.ivPokemon
    fun setup(itemData: PokemonItem) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        PokeRep.getInstance().getPokemon(itemData.name) { isSuccess, response ->
            if(isSuccess) {
                Picasso.get().load(response?.sprites?.front_default).into(img)
            }
        }

        itemView.onClick {
            val bundle = bundleOf("name" to itemData.name)
            itemView.findNavController().navigate(R.id.action_pokeListFragment_to_pokeDetailFragment, bundle)
        }
    }
}