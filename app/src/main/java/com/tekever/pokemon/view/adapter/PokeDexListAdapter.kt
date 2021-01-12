package com.tekever.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tekever.pokemon.databinding.ViewAbilityListItemBinding
import com.tekever.pokemon.databinding.ViewPokedexListItemBinding
import com.tekever.pokemon.databinding.ViewPokemonListItemBinding
import com.tekever.pokemon.model.PokemonPokeDexNumber
import com.tekever.pokemon.view.adapter.viewHolders.PokeDexListViewHolder
import com.tekever.pokemon.view.ui.pokedetails.PokemonViewModel

class PokeDexListAdapter(private val pokemonListViewModel: PokemonViewModel) : RecyclerView.Adapter<PokeDexListViewHolder>(){
    var pokemonList: List<PokemonPokeDexNumber> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeDexListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewPokedexListItemBinding.inflate(inflater, parent, false)
        return PokeDexListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: PokeDexListViewHolder, position: Int) {
        holder.setup(pokemonList[position])
    }

    fun updatePokeDexList(pokemonList: List<PokemonPokeDexNumber>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}