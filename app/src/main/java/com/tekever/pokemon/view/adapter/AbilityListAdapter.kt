package com.tekever.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.databinding.ViewAbilityListItemBinding
import com.tekever.pokemon.model.PokemonAbility
import com.tekever.pokemon.view.adapter.viewHolders.AbilityListViewHolder
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel

class AbilityListAdapter(private val pokemonListViewModel: PokemonViewModel) : RecyclerView.Adapter<AbilityListViewHolder>(){
    var pokemonList: List<PokemonAbility> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewAbilityListItemBinding.inflate(inflater, parent, false)
        return AbilityListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: AbilityListViewHolder, position: Int) {
        holder.setup(pokemonList[position])
    }

    fun updateAbilityList(pokemonList: List<PokemonAbility>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}